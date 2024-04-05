package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.Reply;

public class BoardDao {
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		/*
		 * 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스 제공
		 * - offset : DB에서 가지고 온 리스트에서 몇 번째부터 조회할 것인지에 대한 값
		 * - limit : offset으로부터 몇 개를 조회할 것인지에 대한 값 
		 */
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rBounds = new RowBounds(offset,limit);
		
		//selectList 사용 시 List 타입으로 반환되므로 ArrayList<T> 타입일 경우 형변환 필요
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rBounds);
		return list;
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
}
