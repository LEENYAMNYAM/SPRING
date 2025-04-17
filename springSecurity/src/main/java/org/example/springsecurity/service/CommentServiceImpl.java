package org.example.springsecurity.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springsecurity.dto.CommentDTO;
import org.example.springsecurity.mapper.BoardMapper;
import org.example.springsecurity.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final BoardMapper boardMapper;

    @Override
    @Transactional
    public void insert(CommentDTO comment) {
        log.info("insert comment" + comment);
        //replyCnt 1 증가
        /* 트랜젝션 해주는 놈(spring-tx) 라이브러리 추가해야함.*/
        boardMapper.replyCnt(comment.getBnum(), 1);
        commentMapper.insert(comment);

    }

    @Override
    public List<CommentDTO> selectAll(int bnum) {
        return commentMapper.selectAll(bnum);
    }

    @Override
    @Transactional
    public void delete(int cnum) {
        int bnum = commentMapper.selectByCnum(cnum).getBnum();
        boardMapper.replyCnt(bnum, -1);
        commentMapper.delete(cnum);
    }

    @Override
    public int count(int bnum) {
        return 0;
    }
}
