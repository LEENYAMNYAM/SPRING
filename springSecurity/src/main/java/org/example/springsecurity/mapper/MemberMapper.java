package org.example.springsecurity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springsecurity.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    MemberDTO read(String userid);
}
