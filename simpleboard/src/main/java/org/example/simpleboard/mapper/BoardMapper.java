package org.example.simpleboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    //추가
    @Insert("insert into boards(title, writer, content) values(#{title}, #{writer}, #{content})")
    void insert(BoardDTO board);
    //전체보기
    //@Select("select * from boards")
    List<BoardDTO> findAll(HashMap<String,Object> map);
    //상세보기
    BoardDTO findById(int num);
    //수정
    void update(BoardDTO board);
    //삭제
    void delete(int num);
    //개수
   // @Select("select count(*) from boards")
    int count(HashMap<String, Object> map);
}
