package org.example.simpleboard.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    //번호, 제목, 작성자, 내용, 작성일, 조회수, 댓글개수
    private int num;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int hitcount;
    private int replyCnt;
}
