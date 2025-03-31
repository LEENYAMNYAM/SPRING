package org.example.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    //추가폼
    @GetMapping("insert")
    public String insert() {
        return "board/boardWrite";
    }

    //추가
    @PostMapping("insert")
    public String PostInsert(BoardDTO board) {
        boardService.insert(board);
        log.info("Insert Board " + board);
        return "redirect:list";
    }

    //전체보기
    @GetMapping("list")
    public String boardList(@RequestParam(value = "field", defaultValue = "title") String field,
                            @RequestParam(value = "word", defaultValue = "") String word,
                            Model model) {
        log.info("field : " + field + ", word : " + word);
        HashMap<String, Object> map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        List<BoardDTO> bList = boardService.findAll(map);
        int count = boardService.getCount(map);
        return "board/boardList";
    }

}
