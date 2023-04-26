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


@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    //<a> tag라서 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 필요한 데이터 확인 -> boardList객체 전달해줘야 함
		// 데이터를 가지고 오려면 service를 거치고 dao거치고 mapper사용
		BoardService boardservice = new BoardService();
		List<BoardVO> boardList = boardservice.getBoardList();
		
		System.out.println(boardList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./boardList.jsp");
		request.setAttribute("BOARDLIST", boardList);
		rd.forward(request, response);
		
		
		
		//2. boardList.jsp 화면으로 돌아가기
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
