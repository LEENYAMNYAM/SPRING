package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.dto.FileBoardDTO;
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
        boardRepository.upReadCount(num);       //조회수 증가
        return boardRepository.dao_findByNum(num);
    }

    @Override
    public BoardDTO update(int num) {
        return boardRepository.dao_findByNum(num);
    }

    @Override
    public void update(BoardDTO board) {
        boardRepository.dao_update(board);
    }

    @Override
    public void delete(int num) {
        boardRepository.dao_delete(num);
    }

    @Override
    public int getCount(HashMap<String, Object> map) {
        return boardRepository.dao_getCount(map);
    }

    //파일
    @Override
    public void fileInsert(FileBoardDTO fileBoardDTO) {
        boardRepository.dao_fileInsert(fileBoardDTO);
    }

    @Override
    public List<FileBoardDTO> fileList() {
        return List.of();
    }


}
