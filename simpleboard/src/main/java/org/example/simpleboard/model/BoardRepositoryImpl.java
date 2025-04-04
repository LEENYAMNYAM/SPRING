package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.dto.FileBoardDTO;
import org.example.simpleboard.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardMapper boardMapper;

    @Override
    public void dao_insert(BoardDTO board) {
        boardMapper.insert(board);
    }

    @Override
    public List<BoardDTO> dao_findAll(HashMap<String, Object> map) {
        return boardMapper.findAll(map);
    }

    @Override
    public BoardDTO dao_findByNum(int num) {
        return boardMapper.findById(num);
    }


    @Override
    public void dao_update(BoardDTO board) {
        boardMapper.update(board);
    }

    @Override
    public void dao_delete(int num) {
        boardMapper.delete(num);
    }

    @Override
    public int dao_getCount(HashMap<String, Object> map) {
        return boardMapper.count(map);
    }

    @Override
    public void upReadCount(int num) {
        boardMapper.upReadCount(num);
    }

    //파일
    @Override
    public void dao_fileInsert(FileBoardDTO fileBoardDTO) {
        boardMapper.fileInsert(fileBoardDTO);
    }

    @Override
    public List<FileBoardDTO> dao_fileList() {
        return List.of();
    }


}
