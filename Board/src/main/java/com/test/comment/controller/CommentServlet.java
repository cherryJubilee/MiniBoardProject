package com.test.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.board.vo.BoardVO;
import com.test.comment.service.CommentService;
import com.test.comment.vo.CommentVO;

@WebServlet("/comments")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("확인!");
		
		HttpSession session = request.getSession(); // new로 생성하는 것이 아니라 가져오는 것!
		session.getAttribute("MYID");
		
		request.setCharacterEncoding("UTF-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String writer = (String) session.getAttribute("MYID");
		String content = request.getParameter("content");
		
		System.out.println("writer" + writer + "content" + content);
		
		
		// db에 넣기 위해 객체로 만들기
		CommentVO addCommentvo = new CommentVO();
		addCommentvo.setBoardNum(boardId);
		addCommentvo.setCommentWriter(writer);
		addCommentvo.setCommentContent(content);
		
		// service를 호출하는데 여러 함수 중 addComment 함수를 호출 할 때 정보가 담긴 addCommentvo객체 같이 보내기
		CommentService commentService = new CommentService();
		int result = commentService.addComment(addCommentvo); // 데이터 넣었음		
		
		response.sendRedirect("boarddetail?boardNum=" + boardId);
		

	}
	
	

}
