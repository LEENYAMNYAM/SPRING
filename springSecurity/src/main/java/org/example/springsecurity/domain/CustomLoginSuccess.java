package org.example.springsecurity.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class CustomLoginSuccess implements AuthenticationSuccessHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("request password : " + request.getParameter("password"));
        String encPwd = passwordEncoder.encode(request.getParameter("password"));
        log.info("encPwd : " + encPwd);

        List<String> roleName = new ArrayList<String>();
        authentication.getAuthorities()
                .forEach(role -> roleName.add(role.getAuthority()));
        log.info("roleName : " + roleName);
        response.sendRedirect("/admin");

    }
}
