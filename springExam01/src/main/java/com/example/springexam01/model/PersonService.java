package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;
    //추가
    public void insert(Person person) {
        personDAO.dao_insert(person);
    }
    //전체보기
    public List<Person> findAll() {
      List<Person> personList =   personDAO.dao_list();
      return personList;
    }

}
