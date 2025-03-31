package org.example.simpleboard.model;

import org.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    //추가
    void insert(BoardDTO board);
    //전체보기(검색)
    List<BoardDTO> findAll(HashMap<String,Object> map);
    //상세보기
    BoardDTO findByNum(int num);
    //수정
    void update(BoardDTO board);
    //삭제
    void delete(int num);
    //개수
    int getCount(HashMap<String,Object> map);


}
