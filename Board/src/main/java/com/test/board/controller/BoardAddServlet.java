package com.test.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.service.BoardService;
import com.test.board.vo.BoardVO;

@WebServlet("/posts")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("postTitle");
		String writer = request.getParameter("postWriter");
		String content = request.getParameter("content");

		System.out.println("title" + title + "writer" + writer + content);

//		java.util.Date utilDate = null;
//		java.sql.Date sqlDate = null;
//		
//        String created_at = request.getParameter("created-at");	 // 문자열 날짜 형식이 이와 같다고 가정합니다.
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 문자열의 날짜 형식과 일치하도록 SimpleDateFormat을 생성합니다.
//   
//        
//        try {
//        	utilDate = sdf.parse(created_at); // 문자열을 Date 타입으로 변환합니다.
//        	sqlDate = new java.sql.Date(utilDate.getTime());
//            System.out.println("SQL Date: " + sqlDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//		

		// db에 넣기 위해 객체로 만들기
		BoardVO boardvo = new BoardVO();
		boardvo.setBoardTitle(title);
		boardvo.setBoardWriter(writer);
		boardvo.setBoardContent(content);

		// service를 호출하는데 여러 함수 중 createBoard 함수를 호출 할 때 정보가 담긴 boardvo객체 같이 보내기
		BoardService boardService = new BoardService();
		int result = boardService.createBoard(boardvo); // 데이터 넣었음

		// 3->2으로 넘어가는 화면을 forward합니다.
		// boardList.jsp 화면으로 넘어갈 것입니다.
		// boardList.jsp 화면에서 띄워야 할 데이터를 함께 보내줘야 합니다.
		// 게시글 싸그리 가져와야 합니다.
		List<BoardVO> boardlist = boardService.getBoardList();
		
		request.setAttribute("BOARDLIST", boardlist); //검색해서 가져온 boardlist 담기
		
		//RequestDispatcher 프론트로 보내주는것
		RequestDispatcher rd = request.getRequestDispatcher("./boardList.jsp"); 
		rd.forward(request, response);
		// 검색 JSP를 보여줘요!
		

	}
}
