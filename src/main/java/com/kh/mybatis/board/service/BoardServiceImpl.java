package com.kh.mybatis.board.service;

import java.util.ArrayList;

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

		Board b = new Board();
		sqlSession.close();
		return b;
	}
	
	@Override
	public ArrayList<Reply> selectRelplyList(int boardNo){
		SqlSession sqlSession = getSqlSession();

		ArrayList<Reply> replyList= new ArrayList<>();
		sqlSession.close();
		return replyList;
	}
}
