package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.Reply;

import static com.kh.mybatis.template.Template.*;


public class BoardServiceImpl implements BoardService{
	BoardDao boardDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		int count = boardDao.selectListCount(sqlSession);
		sqlSession.close();
		return count;
	}
	
	@Override
	public ArrayList<Board> slectList(PageInfo pi){
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> board = boardDao.selectList(sqlSession, pi);
		sqlSession.close();
		return board;
	}
	
	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();

		int result = boardDao.increaseCount(sqlSession, boardNo);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlSession();

		Board b = boardDao.selectBoard(sqlSession, boardNo);
		sqlSession.close();
		return b;
	}
	
	@Override
	public ArrayList<Reply> selectRelplyList(int boardNo){
		// 게시글 정보를 전달받아 댓글 목록 조회
		SqlSession sqlSession = getSqlSession();
		ArrayList<Reply> replyList = boardDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return replyList;
	}
	
	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		int result = boardDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return result;
	}
	
	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi){
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	}
}
