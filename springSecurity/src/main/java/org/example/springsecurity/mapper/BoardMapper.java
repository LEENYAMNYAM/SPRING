package org.example.springsecurity.mapper;

import org.apache.ibatis.annotations.*;
import org.example.springsecurity.dto.BoardDTO;
import org.example.springsecurity.dto.PageDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    //추가
    @Insert("insert into boards(title, writer, content) values(#{title}, #{writer}, #{content})")
    void insert(BoardDTO board);
    //전체보기(페이징X, 검색X)
//    @Select("select * from boards")
//    List<BoardDTO> selectAll();
    //전체보기(페이징만있을경우)
    List<BoardDTO> selectAll(HashMap<Object, Integer> map);
    //상세보기
    @Select("select * from boards where num=#{num}")
    BoardDTO selectById(int num);
    //수정
    @Update("update boards set title=#{title}, writer=#{writer}, content=#{content} where num=#{num}")
     void updateBoard(BoardDTO board);
    //삭제
    @Delete("delete from boards where num=#{num}")
    void deleteBoard(int num);
    //개수
    int count();
    // replyCnt 증감
    @Update("update boards set replyCnt= replyCnt + #{amount} where num=#{bnum}")
    /* mybatis에 두개의 값을 보낼려면 @Param을 쓰든가 하나로(Map으로) 묶든가 해야됨 */
    void replyCnt(@Param("bnum") int bnum,
                  @Param("amount") int amount);

}
