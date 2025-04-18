package org.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springsecurity.dto.CommentDTO;
import org.example.springsecurity.service.BoardService;
import org.example.springsecurity.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/reply/*")
@RequiredArgsConstructor
@RestController
@Log4j2
public class CommentController {
    private final CommentService commentService;
    private final BoardService boardService;

    //전체보기
    @GetMapping("commentList/{num}")
//    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> getCommentList(@PathVariable("num") int num) {
        log.info("num : " + num);
        List<CommentDTO> clist = commentService.selectAll(num);
        int count = boardService.selectById(num).getReplyCnt();
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("clist", clist);
        hm.put("count", count);
        log.info("hm : " + hm);
        return new ResponseEntity<HashMap<String, Object>>(hm, HttpStatus.OK);
    }

    //댓글 추가
    @PostMapping("commentInsert")
//    @ResponseBody
    public ResponseEntity<String> insertComment(@RequestBody CommentDTO comment){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) auth.getPrincipal();

        log.info(comment);
        comment.setUserid(userDetails.getUsername());
        commentService.insert(comment);
        return new ResponseEntity<>("Success", HttpStatus.OK);
//        리턴값은 Spring으로 줘도 됨
//        return "success";
    }

    //댓글 삭제
    @DeleteMapping("delete/{cnum}")
    public ResponseEntity<String> deleteComment(@PathVariable("cnum") int cnum){
        log.info(cnum);
        commentService.delete(cnum);
        return new ResponseEntity<>(Integer.toString(cnum), HttpStatus.OK);
    }

}
