package org.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
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
