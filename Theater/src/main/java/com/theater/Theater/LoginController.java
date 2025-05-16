package com.theater.Theater;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String pw,
                        HttpSession session,
                        Model model) {

        User user = service.login(id, pw);

        // 만약 로그인해서 user정보가 있으면
        if (user != null) {
            session.setAttribute("loginUser", user);
//            model.addAttribute("user",user);
            session.setMaxInactiveInterval(1800); //세션 설정하고
            return "redirect:/queryMovie"; //하고 조회페이지로 이동
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    //session.invalidation();으로 세션을 만료해줌
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    //회원가입 페이지로 가는 서블릿
    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    //실제 회원가입 하는 메소드
    @PostMapping("/join")
    public String join(@ModelAttribute User user, Model model) {
        try {
            service.join(user);
            model.addAttribute("msg", "회원가입 성공! 로그인해주세요.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("msg", "회원가입 실패: 중복 ID가 존재할 수 있습니다.");
            e.printStackTrace();  //오류나서 검사하느라
            return "join";
        }
    }
}