package com.test.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.board.vo.BoardVO;

// 게시글 목록 데이터베이스에서 조회하기
public class BoardDAO {
	
	private SqlSession sqlSession = null;
	
	public BoardDAO() {
		
	}
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	public List<BoardVO> selectAll() {

		List<BoardVO> list = null;

		list = sqlSession.selectList("board.list.selectBoard"); // 다 가져올것이라서 파라미터타입 없음

		return list;
	}
   
	// 3. 새글 작성 - db에 넣어주기
	public int createPost(BoardVO boardvo) {
		
		//book.xml에 있는 mapper(sql문에 따라)을 통해서 boardvo객체를 db에 전달 + config에 mapper추가하기
		int result = sqlSession.insert("board.list.insertBoard", boardvo);  
		
		return result;
	}

	public BoardVO getBoard(int boardId) {

		
		BoardVO result = null;
		
		result = sqlSession.selectOne("board.list.selectBoardOne", boardId);
		
		return result;
	}
}
