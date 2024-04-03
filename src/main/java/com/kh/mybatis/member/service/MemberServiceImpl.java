package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.template.Template;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = mDao.insertMember(sqlSession, m);
		if(result > 0) {
			sqlSession.commit();
		}
		// rollback : 여러 개의 DML문을 실행시켰을 때만 필수록 해야하고, 단일행일 경우 생략가능
		//				=> 일반 게시판 등록 시 : 게시글 정보 + 첨부파일 정보
		sqlSession.close();
		return result;
	}
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		int result = 0;
		return result;
	}
	
	@Override	
	public int deleteMember(Member m) {
		int result = 0;
		return result;
	}
}
