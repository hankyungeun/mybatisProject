package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	public int insertMember(SqlSession sqlSession, Member m) {
	/*
	 * sqlSession객체에서 제공하는 메소드를 통해 sql문을 찾아서 실행하고, 결과를 바로 받음
	 * 
	 * 결과 = sqlSession.종류에 맞는 메소드("매퍼의_별칭.실행할_sql문_id, [sql문을_완성시킬_객체]);
	 */
		int result = sqlSession.insert("memberMapper.insertMember", m);
		return result;
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		
		// selectOne : 조회된 결과가 없을 경우 null 반환
		return loginUser;
	}
}
