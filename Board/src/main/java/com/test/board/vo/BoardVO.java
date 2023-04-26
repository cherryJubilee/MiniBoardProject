package com.test.board.vo;

import java.sql.Date;

import com.test.board.vo.BoardVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardPostdate;
	private int boardLike;


}
