package org.example.springsecurity.service;

import org.example.springsecurity.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    //추가
    void insert(CommentDTO comment);
    //전체보기
    List<CommentDTO> selectAll(int bnum);
    //삭제
    void delete(int cnum);
    //개수
    int count(int bnum);

}
