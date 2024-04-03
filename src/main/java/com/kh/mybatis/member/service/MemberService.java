package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	// 인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
	
	/*public abstract - 생략가능 인터페이스는 자동으로 public abstract*/ int insertMember(Member m);
	Member loginMember(String id, String pwd);
	int updateMember(Member m);
	int deleteMember(Member m);
}
