package com.test.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.test.member.vo.MemberVO;

public class MemberDAO {
	
	private SqlSession session;
	
	public MemberDAO() {
		// 기본 생성자
	}
	
	
	public MemberDAO(SqlSession session) {
		this.session = session;
	}
	
	public MemberVO select(MemberVO vo) {
		vo = session.selectOne("board.member.selectMember", vo);
		
		return vo;
	}

}