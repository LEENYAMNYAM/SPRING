package org.example.springsecurity.dto;

import lombok.Data;

import java.util.List;

@Data
public class MemberDTO {
    private String userid;
    private String username;
    private String userpw;
    private String regdate;
    private String updatedate;
    private boolean enabled;
    private List<AuthDTO> authList;
}
