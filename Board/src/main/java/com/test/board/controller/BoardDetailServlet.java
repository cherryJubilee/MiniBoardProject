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
import com.test.comment.service.CommentService;
import com.test.comment.vo.CommentVO;


@WebServlet("/boarddetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDetailServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardId = Integer.parseInt(request.getParameter("boardNum"));
		
		BoardService boardService = new BoardService();
		BoardVO boardvo = boardService.getBoard(boardId);
				
		CommentService commentService = new CommentService();
		List<CommentVO> commentList = commentService.getComment(boardId);
		
		request.setAttribute("BOARDLIST", commentList); //검색해서 가져온 boardlist 담기
		
		//RequestDispatcher 프론트로 보내주는것
		RequestDispatcher rd = request.getRequestDispatcher("./boardDetail.jsp"); 
		request.setAttribute("BOARDVO", boardvo);
		request.setAttribute("COMMENTSVO", commentList);

		rd.forward(request, response);
		// 검색 JSP를 보여줘요!
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
