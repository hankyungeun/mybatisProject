package com.kh.mybatis.board.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.PageInfo;
import com.kh.mybatis.board.model.vo.Reply;

public interface BoardService {
	// 게시글 조회
	int selectListCount();
	ArrayList<Board> slectList(PageInfo pi);
	// 게시글 상세조회
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	ArrayList<Reply> selectRelplyList(int boardNo);
}
