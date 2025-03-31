package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void insert(BoardDTO board) {
        boardRepository.dao_insert(board);
    }

    @Override
    public List<BoardDTO> findAll(HashMap<String, Object> map) {
        return boardRepository.dao_findAll(map);
    }

    @Override
    public BoardDTO findByNum(int num) {
        return null;
    }

    @Override
    public void update(BoardDTO board) {

    }

    @Override
    public void delete(int num) {

    }

    @Override
    public int getCount(HashMap<String, Object> map) {
        return boardRepository.dao_getCount(map);
    }
}
