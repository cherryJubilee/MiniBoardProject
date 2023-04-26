package com.test.member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.member.dao.MemberDAO;
import com.test.member.vo.MemberVO;
import com.test.util.mybatis.MyBatisConnectionFactory;

public class MemberService {
   
   private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
   
   public MemberVO login(MemberVO vo) {
		// 로그인 처리를 해야 한다.
		// DB처리만 하면 됨.
		// DAO 객체를 만들어서 DB처리를 위임.
      
      SqlSession session = factory.openSession();
      MemberDAO dao = new MemberDAO(session);
      
      vo = dao.select(vo);
   // SELECT같은 경우 Transaction을 처리할 필요가 없으므로 바로 리턴해도 됨!
      // session.commit();
      // session.rollback();
      return vo;
   }
}