package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;
    //추가
    public void insert(Person person) {
        personDAO.dao_insert(person);
    }


    //전체보기(검색미포함)
    public List<Person> findAll() {
        List<Person> personList =  personDAO.dao_list();
        return personList;
    }

    //전체보기(검색포함)
    public List<Person> findAll(String field, String word) {
        HashMap<String, String > map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        List<Person> personList = personDAO.dao_list("searchList", map);
        return personList;
    }


    // 개수(검색미포함)
    public int getCount() {
        return personDAO.dao_count();
    }

    // 개수(검색포함)
    public int getCount(String field, String word) {
        HashMap<String, String > map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        return personDAO.dao_count("searchCount", map);
    }

    //상세보기
    public Person view(String id) {
        Person person = personDAO.dao_view(id);
    return person;
    }

    //삭제
    public void delete(String id){
        personDAO.dao_delete(id);
    }

    // 수정폼
    public Person updateForm(String id) {
        Person person = personDAO.dao_view(id);
        return person;
    }

    //수정
    public void update(Person person) {
        personDAO.dao_update(person);
    }


}
