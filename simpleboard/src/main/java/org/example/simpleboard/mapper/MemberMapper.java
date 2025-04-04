package org.example.simpleboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.simpleboard.dto.MemberDTO;

@Mapper
public interface MemberMapper {

    //추가
    @Insert("insert into member(id, password, name, addr) values(#{id}, #{password}, #{name}, #{addr})")
    void join(MemberDTO memberDTO);
    //아이디 중복 확인
    @Select("select count(*) from member where id=#{id}")
    int idCheck(String id);
    //로그인 체크
    @Select("select * from member where id=#{id}")
    MemberDTO loginCheck(String id);
    //정보수정
    @Update("update member set name=#{name}, password=#{password}, addr=#{addr} where id=#{id}")
    void update(MemberDTO memberDTO);
}
