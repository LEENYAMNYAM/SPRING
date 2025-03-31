package com.example.springexam01.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//setter,getter를 자동으로 만들어주는 놈(Project Lombok)을 maven Repository에서 가져와서
//pom.xml에 추가하면 됨.

@Getter @Setter
/* 골뱅이 + Data 라는 놈도 있는데 이놈은 getter, setter, 생성자, to_String이 모두 있는 것. 안쓰는것을 추천함. */
public class Person {
    private String id;
    private String name;
    private String password;
    private String gender;
    private String job;



}
