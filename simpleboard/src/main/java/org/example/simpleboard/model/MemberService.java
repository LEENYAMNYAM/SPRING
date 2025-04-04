package org.example.simpleboard.model;

import org.example.simpleboard.dto.MemberDTO;

public interface MemberService {
    //추가
    void join(MemberDTO memberDTO);
    //아이디 중복확인
    int idCheck(String id);

    //로그인 체크
    MemberDTO loginCheck(String id);

    //정보수정
    void update(MemberDTO memberDTO);
}
