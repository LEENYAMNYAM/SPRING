package org.example.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("barr", bList);
        model.addAttribute("count", count);
        return "board/boardList";
    }

    @GetMapping("view")
    public String boardView(@RequestParam("num") int num, Model model) {
        BoardDTO board = boardService.findByNum(num);
        model.addAttribute("board", board);
        return "board/boardView";
    }

    // 삭제
    // 레스트방식으로 넘어올 때 받으려면 @RequestParm이 아니라, Mapping 뒤에 변수명을 받아서 @PathVariable로 가져와야함
    @DeleteMapping("delete/{num}")
    @ResponseBody
    public int delete(@PathVariable("num") int num) {
        log.info("Delete Board " + num);
        boardService.delete(num);
        /* JSON객체로 읽을 수 있도록 보내주어야 하기 때문에(콜백함수가 있기 때문에 콜백함수로 넘어가기 때문에),
         @ResponseBody를 불러주고 int로 리턴해야하고,
         라이브러리(pom.xml)에 Jackson Databind를 추가해야함 */
        return num;
    }

    // 수정 폼
    @GetMapping("update/{num}")
    public String update(@PathVariable("num") int num, Model model) {

        BoardDTO board = boardService.findByNum(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    // 수정
    @PutMapping("update")
    @ResponseBody
    public int update(@RequestBody BoardDTO board) {
        /* JSON 객체로 파라미터를 받아올때는 @RequestBody를 어노테이션 해줘야함 */
        boardService.update(board);
        return board.getNum();
    }
}
