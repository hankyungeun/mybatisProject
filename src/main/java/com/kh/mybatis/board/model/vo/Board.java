package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int count;
	private Date createDate;
	private String status;
}
