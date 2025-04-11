package org.example.springsecurity.service;

import org.example.springsecurity.dto.BoardDTO;
import org.example.springsecurity.dto.PageDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    //추가
    void insertBoard(BoardDTO board);
    //전체보기(페이징X, 검색X)
//    List<BoardDTO> selectAll();
    //전체보기(페이징O, 검색X)
    List<BoardDTO> selectAll(HashMap<Object, Integer> map);
    //상세보기 & 수정폼
    BoardDTO selectById(int num);
    //수정
    void updateBoard(BoardDTO board);
    //삭제
    void deleteBoard(int num);
    //개수
    int getCount();
}
