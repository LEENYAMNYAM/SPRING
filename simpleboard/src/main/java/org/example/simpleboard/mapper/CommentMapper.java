package org.example.simpleboard.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.simpleboard.dto.CommentDTO;

import java.util.List;

@Mapper
public interface CommentMapper {
    //추가
    @Insert("insert into commentboard(userid, content, bnum) values(#{userid}, #{content}, #{bnum})")
    void insert(CommentDTO comment);
    //전체보기
    @Select("select * from commentboard where bnum=#{bnum}")
    List<CommentDTO> selectAll(int bnum);

    //selectOneByCnum
    @Select("select * from commentboard where cnum=#{cnum}")
    CommentDTO selectByCnum(int cnum);

    //삭제
    @Delete("delete from commentboard where cnum=#{cnum}")
    void delete(int cnum);

}
