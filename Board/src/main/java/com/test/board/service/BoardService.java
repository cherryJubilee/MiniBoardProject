package com.test.board.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.board.dao.BoardDAO;
import com.test.board.vo.BoardVO;
import com.test.util.mybatis.MyBatisConnectionFactory;



public class BoardService {
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	
	public List<BoardVO> getBoardList() {
		
		SqlSession session = factory.openSession();

		BoardDAO dao = new BoardDAO(session);
		List<BoardVO> resultList = dao.selectAll(); //여러개 list로 가져올거고 이것은 boardVO타입. 
		session.close();
		return resultList;
	}


	public int createBoard(BoardVO boardvo) {
		
		SqlSession session = factory.openSession();

		BoardDAO dao = new BoardDAO(session);  // dao가 db가 연결되도록 session한개 주기 = 연결됨!
		int result = 0;
		
		try {
			result = dao.createPost(boardvo); // dao가 성공1 실패0
			if(result == 0) {
				throw new RuntimeException("게시글 작성이 실패 되었습니다.");
			} else {
				session.commit(); //트랜젝션 커밋
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		session.close();

		return result;
	}


	public BoardVO getBoard(int boardId) {
		SqlSession session = factory.openSession();
		BoardDAO dao = new BoardDAO(session);
		BoardVO result = dao.getBoard(boardId);

		
		return result;
	}

}
