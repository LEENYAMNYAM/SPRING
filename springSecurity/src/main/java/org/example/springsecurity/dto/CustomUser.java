package org.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Getter @Setter
public class CustomUser extends User {

    private MemberDTO memberDTO;

    public CustomUser(MemberDTO member) {
        super(member.getUserid(),
                member.getUserpw(),
                member.getAuthList().stream().map(authDTO
                                                  -> new SimpleGrantedAuthority(authDTO.getAuth()))
                        .collect(Collectors.toList()));         // super 생성자
        this.memberDTO = member;
    }

//    public CustomUser(String username,
//                      String password,
//                      Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//    }
}
