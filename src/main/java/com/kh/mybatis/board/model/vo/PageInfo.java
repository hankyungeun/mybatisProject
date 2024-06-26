package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PageInfo {
	private int listCount;
	private int currentPage;
	private int pageLimit;
	private int boardLimit;
	private int maxPage;
	private int startPage;
	private int endPage;
}
