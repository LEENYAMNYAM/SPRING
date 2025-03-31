package com.example.springexam01.controller;

import com.example.springexam01.dto.Person;
import com.example.springexam01.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PersonService personService;
    //추가폼
    @GetMapping("pinsert")
    public String insert() {
        return "insert";
    }
    //추가
    @PostMapping("pinsert")
    public String insertPost(@ModelAttribute Person person) {
        personService.insert(person);
        return "redirect:plist";
    }

    //전체보기
    @GetMapping("plist")
    public String list(Model model) {
       List<Person> personList =  personService.findAll();
       model.addAttribute("personList", personList);
       return "list";
    }
}
