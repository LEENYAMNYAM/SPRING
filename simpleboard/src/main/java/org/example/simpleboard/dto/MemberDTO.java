package org.example.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MemberDTO {
    private String id;
    private String name;
    private String password;
    private String addr;
    private Date regdate;


}
