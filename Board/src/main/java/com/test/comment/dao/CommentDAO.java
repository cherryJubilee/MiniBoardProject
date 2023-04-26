package com.test.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.comment.vo.CommentVO;

public class CommentDAO {

	private SqlSession sqlSession = null;

	public CommentDAO(SqlSession session) {
		this.sqlSession = session;
	}

	public int createComment(CommentVO addCommentvo) {

		System.out.println(addCommentvo);
		// book.xml에 있는 mapper(sql문에 따라)을 통해서 boardvo객체를 db에 전달 + config에 mapper추가하기
		int result = sqlSession.insert("comment.list.insertComment", addCommentvo);

		return result;
	}

	public List<CommentVO> getComment(int boardId) {
		
		List<CommentVO> result = null;

		result = sqlSession.selectList("comment.list.selectComment", boardId);

		return result;
	}

}
