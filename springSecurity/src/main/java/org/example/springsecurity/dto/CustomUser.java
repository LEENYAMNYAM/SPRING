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

        /* 시큐리티가 적용되게 됨 */
        super(member.getUserid(),
                member.getUserpw(),
                member.getAuthList().stream().map(authDTO
                                                  -> new SimpleGrantedAuthority(authDTO.getAuth()))
                        .collect(Collectors.toList()));         // super 생성자
        this.memberDTO = member;
        /* 시큐리티가 적용된 user객체가 반환됨 */
    }

//    public CustomUser(String username,
//                      String password,
//                      Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//    }
}
