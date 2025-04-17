package org.example.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecurity.dto.BoardDTO;
import org.example.springsecurity.dto.PageDTO;
import org.example.springsecurity.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardDTO board) {
        boardMapper.insert(board);
    }

//    @Override
//    public List<BoardDTO> selectAll() {
//        return boardMapper.selectAll() ;
//    }

    @Override
    public List<BoardDTO> selectAll(HashMap<Object, Integer> map) {
        return boardMapper.selectAll(map);
    }

    @Override
    public BoardDTO selectById(int num) {
        return boardMapper.selectById(num);
    }

    @Override
    public void updateBoard(BoardDTO board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int num) {
        boardMapper.deleteBoard(num);
    }

    @Override
    public int getCount() {
        return boardMapper.count();
    }
}
