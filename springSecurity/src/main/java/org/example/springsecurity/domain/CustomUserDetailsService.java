package org.example.springsecurity.domain;

import lombok.extern.log4j.Log4j2;
import org.example.springsecurity.dto.CustomUser;
import org.example.springsecurity.dto.MemberDTO;
import org.example.springsecurity.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        log.info("username : " + username);
        MemberDTO memberDTO = memberMapper.read(username);
        log.info("memberDTO : "+ memberDTO);
        CustomUser user = new CustomUser(memberDTO);
        log.info("user : "+ user);
        return memberDTO == null ? null : user;
    }
}
