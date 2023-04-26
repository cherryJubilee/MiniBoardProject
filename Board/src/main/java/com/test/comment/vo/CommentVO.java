package com.test.comment.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int boardNum;
	private int commentNum;
	private String commentWriter;
	private String commentContent;

}
