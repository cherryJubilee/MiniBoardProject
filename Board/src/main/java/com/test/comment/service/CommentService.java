package com.test.comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.board.dao.BoardDAO;
import com.test.board.vo.BoardVO;
import com.test.comment.dao.CommentDAO;
import com.test.comment.vo.CommentVO;
import com.test.util.mybatis.MyBatisConnectionFactory;

public class CommentService {
	
	SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

	public int addComment(CommentVO addCommentvo) {
		
		SqlSession session = factory.openSession();
		
		CommentDAO dao = new CommentDAO(session);
		int result = 0;

		try {
			result = dao.createComment(addCommentvo); // dao가 성공1 실패0
			if(result == 0) {
				throw new RuntimeException("댓글 작성이 실패 되었습니다.");
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
	
	public List<CommentVO> getComment(int boardId) {
		SqlSession session = factory.openSession();
		CommentDAO dao = new CommentDAO(session);
		List<CommentVO> result = dao.getComment(boardId);

		return result;
	}

}
