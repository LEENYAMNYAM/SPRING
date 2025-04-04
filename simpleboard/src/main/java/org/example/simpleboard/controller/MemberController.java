package org.example.simpleboard.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.MemberDTO;
import org.example.simpleboard.model.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member/*")
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("join")
    public String join() {
        return "member/join";
    }

    @ResponseBody
    @PostMapping("join")
    public String joinPost (@RequestBody MemberDTO memberDTO) {
        /*JSON형식을 받을때는 @RequestBody 써주자*/
        log.info(memberDTO);
        int flag = memberService.idCheck(memberDTO.getId());
        if(flag != 0) return "fail";
        memberService.join(memberDTO);
        return "success";
    }

    //로그인 폼
    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    //로그인
    @PostMapping("login")
    @ResponseBody
    public String loginPost (@RequestBody MemberDTO memberDTO, HttpSession session) {
        //성공(success)  / 비번오류("fail") / 회원아님("no")
        MemberDTO member = memberService.loginCheck(memberDTO.getId());
        if(member == null){
            return "no";
        }else if(memberDTO.getPassword().equals(member.getPassword())){
            session.setAttribute("sMember", member);
            /* 로그인 상태 유지를 위해 session 객체를 불러옴 */
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        // session.removeAttribute("sMember");
        // sMember만 삭제할려면 removeAttribute()
        session.invalidate();
        // 모든 session 지우려면 invalidate()
        return "member/login";
    }

    //update폼
    @GetMapping("update")
    public void update(MemberDTO memberDTO) {
    }

    @PutMapping("update")
    @ResponseBody
    public String updatePost(@RequestBody MemberDTO memberDTO, HttpSession session) {
        log.info(memberDTO.getAddr());
        memberService.update(memberDTO);
        session.invalidate();
        return "success";
    }
}
