package org.example.springsecurity.controller;

import org.example.springsecurity.dto.BoardDTO;
import org.example.springsecurity.dto.PageDTO;
import org.example.springsecurity.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/board/*")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("list")
    public String list(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
                       Model model) {
        //페이징
        int currentPage = Integer.parseInt(pageNum);
        int pageSize = 5;
        int total = boardService.getCount();

        HashMap<Object, Integer> map = new HashMap<>();
        map.put("startPage", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<BoardDTO> bList = boardService.selectAll(map);

        PageDTO pageDTO = new PageDTO(total, currentPage, pageSize);
//        List<BoardDTO> bList = boardService.selectAll();
        model.addAttribute("barr", bList);
        model.addAttribute("count", total);
        model.addAttribute("p", pageDTO);
        return "board/boardList";
    }
    @GetMapping("write")
    @PreAuthorize("isAuthenticated()")
    public String write(){
        return "board/boardWrite";
    }
    @PostMapping("write")
    public String write(BoardDTO boardDTO){
        boardService.insertBoard(boardDTO);
        return "redirect:list";
    }

    @GetMapping("view")
    public String view(@RequestParam("num") int num, Model model){
        BoardDTO board =  boardService.selectById(num);
        model.addAttribute("board", board);
        return "board/boardView";
    }

    @GetMapping("update/{num}")
    public String update(@PathVariable("num") int num, Model model){
        BoardDTO board =  boardService.selectById(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PutMapping("update")
    @ResponseBody
    public int update(@RequestBody BoardDTO boardDTO){
        boardService.updateBoard(boardDTO);
        return boardDTO.getNum();
    }

    @DeleteMapping("delete/{num}")
    @ResponseBody
    public int delete(@PathVariable("num") int num){
        boardService.deleteBoard(num);
        return num;
    }


}
