package org.example.simpleboard.model;

import org.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardRepository {
    //추가
    void dao_insert(BoardDTO board);
    //전체보기(검색)
    List<BoardDTO> dao_findAll(HashMap<String,Object> map);
    //상세보기
    BoardDTO dao_findByNum(int num);
    //수정
    void dao_update(BoardDTO board);
    //삭제
    void dao_delete(int num);
    //개수
    int dao_getCount(HashMap<String,Object> map);
    //조회수 증가
    void upReadCount(int num);

}
