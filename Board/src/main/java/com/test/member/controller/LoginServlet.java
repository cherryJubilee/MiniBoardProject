package com.test.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.board.service.BoardService;
import com.test.board.vo.BoardVO;
import com.test.member.service.MemberService;
import com.test.member.vo.MemberVO;




@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.입력
		// 입력받는것은 당연히 controller의 역할 
		request.setCharacterEncoding("UTF-8");  //한글처리
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(userID);
		vo.setMemberPw(userPW);
		
		// 2.로직 
		// 로직처리를 하기 위해 service 객체에게 위임(로그인 되는지 안되는지 확인해줘). 
		// 그리고 그 결과만 받아온다!어떤 형식으로 받아볼지는 생각해보기
		MemberService service = new MemberService();
		//직관적으로(개별적) 데이터 전달 하는 방법 - 사용 x
		//boolean loginResult = service.login(userID, userPW); 
		
		//vo를 사용해서 데이터 전달하는것. userID, userPW 두 개를 객체화 하기	 
		MemberVO loginVO = service.login(vo);
		
		HttpSession session = request.getSession(); // new로 생성하는 것이 아니라 가져오는 것!
		// 있으면 가져오고 없으면 생성해서 가져와요
		session.setAttribute("MYID", userID); // 세션에 저장 
		session.setAttribute("MYPW", userPW);
		
		// 3.출력
		if(loginVO == null) {
			// 로그인 HTML을 다시 보여줘요!
			response.sendRedirect("./login.html");
		} else {
			response.sendRedirect("./boardList");
//			BoardService service1 = new BoardService();
//			List<BoardVO> boardlist = service1.getBoardList(); // board 객체를 불러옴
//
//			
//			System.out.println(boardlist);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("./boardList.jsp");
//		
//			request.setAttribute("MEMBER", loginVO);
//			request.setAttribute("BOARDLIST", boardlist);
//			rd.forward(request, response);
			// 검색 JSP를 보여줘요!
			
			

		}

	}

}
