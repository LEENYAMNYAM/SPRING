package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/* */
@Repository
public class PersonDAO {

    @Autowired
    private SqlSession sqlMapper;       /* root-context에 만든 id랑 동일하게 */

    //추가
    public void dao_insert(Person person) {
        sqlMapper.insert("personInsert",person);
    }

    //전체보기(검색미포함)
    public List<Person> dao_list(){
        List<Person> personList = sqlMapper.selectList("personList");
        return personList;
    }
    //전체보기(검색포함)
    public List<Person> dao_list(String mid, HashMap<String, String> map) {
        List<Person> personList = sqlMapper.selectList(mid, map);
        return personList;
    }

    //개수(검색미포함)
    public int dao_count() {
        return sqlMapper.selectOne("personCount");
    }
    //개수(검색포함)
    public int dao_count(String mid, HashMap<String, String> map) {
        return sqlMapper.selectOne(mid, map);
    }


    //상세보기
    public Person dao_view(String id) {
        return sqlMapper.selectOne("personView",id);
    }

    // 삭제
    public void dao_delete(String id) {
        sqlMapper.delete("personDelete",id);
    }

    //수정
    public void dao_update(Person person) {
        sqlMapper.update("personUpdate",person);
    }
}
