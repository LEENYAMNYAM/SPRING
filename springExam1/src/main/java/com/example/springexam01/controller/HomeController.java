package com.example.springexam01.controller;

import com.example.springexam01.dto.Person;
import com.example.springexam01.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired   /* Autowired는 Type으로 연결하게됨.*/
    private PersonService personService;

    // 추가 폼
    @GetMapping("pinsert")
    public String insert() {
        return "insert";
        /*  여기서 리턴값인 insert는 문자형 변수가 아니라 insert.jsp를 의미함.
        두개를 연결할거고 servlet-context.xml 에 알려줘야함 */

    }
    //추가
    @PostMapping("pinsert")
    public String insertPost(@ModelAttribute Person person) {
        /* 알아서 pinsert에서 가져온 값이 Person 클래스에 저장됨*/
        personService.insert(person);
        /*service 가 PersonService.java의 클래스라는 것을 알아보는 방법은 총 3개지임
        * 1. 어노테이션(골뱅이)를 사용하기 (클래스 안에 가장 윗 부분에 추가했음)
        * 2. ?
        * 3. ?*/
        return "redirect:plist";
        //plist.jsp를 의미, 기본이 forword 방법이라서 redirect로 하려면 써줘야함
    }

    // 전체보기(검색미포함)
//    @GetMapping("plist")
//    public String list(Model model) {
//        List<Person> personList = personService.findAll();
//        int count = personService.getCount();
//        model.addAttribute("count", count);
//        model.addAttribute("personList", personList);
//        return "list";          //list는 list.jsp를 의미
////        maven에서 자카르타 jar두개 추가하기(pom.xml에)
//    }

    // 전체보기(검색포함)
    @GetMapping("plist")
    public String list(@RequestParam(value = "field", required = false, defaultValue = "name") String field,
                       @RequestParam(value = "word", required = false, defaultValue = "") String word,
                       Model model) {
//    RequestParam()의미 : field 파라미터 가져올껀데 required- false(꼭 필요한거 아님), defaultValue="name" 기본값은 name이라는 의미
        List<Person> personList = personService.findAll(field, word);
        int count = personService.getCount(field, word);
//      각각의 함수에 검색주제(field)와 검색어(word)를 보내줘야함.

        model.addAttribute("count", count);
        model.addAttribute("personList", personList);
        return "list";
    }

    // 상세보기
    @GetMapping("pview")
    public String view(@RequestParam("id") String id, Model model) {  //파라미터이름을 같게 쓰면 바로 값을 받아와줌.
        Person person = personService.view(id);
        model.addAttribute("person", person);
        return "view";
    }

    // a태그 삭제
    @GetMapping("delete")
    public String delete(@RequestParam("id") String id, Model model) {
        personService.delete(id);
        return "redirect:plist";
    }

    //a태그 수정(수정폼)
    @GetMapping("update")
    public String update(@RequestParam("id") String id, Model model) {
        Person person = personService.updateForm(id);
        model.addAttribute("person", person);
        return "update";
    }

    // 버튼 수정
    @PostMapping("update")
    public String updatePost(@ModelAttribute Person person) {
        personService.update(person);
        return "redirect:plist";
    }


}
