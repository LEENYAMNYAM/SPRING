package org.example.springsecurity.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/customLogin")
    public void customLogin(){}

    @GetMapping("/admin")
    public void admin(){}

    @GetMapping("/all")
    public void all(){}

    @GetMapping("/manager1")
    public void manager(){}

}
