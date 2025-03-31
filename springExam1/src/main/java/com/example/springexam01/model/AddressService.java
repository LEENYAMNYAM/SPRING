package com.example.springexam01.model;

import com.example.springexam01.dto.AddressDTO;

import java.util.HashMap;
import java.util.List;

public interface AddressService {

    //추가
    public void insertAddress(AddressDTO addressDTO);
    //전체보기
    public List<AddressDTO> findAll();
    //전체보기(검색)
    public List<AddressDTO> searchAddress(HashMap<String, String> map);
    //상세보기
    public AddressDTO viewAddress(int num);
    //수정
    public void updateAddress(AddressDTO addressDTO);
    //삭제
    public void deleteAddress(int num);
    //갯수
    public int countAddress();
    //갯수(검색)
    public int searchCount(HashMap<String, String> map);

}
