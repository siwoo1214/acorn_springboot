package com.example.day07SessionPrac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {

    //로그인 처리 메소드
    @GetMapping("/signup")
    public String signup(){

        return "redirect:/home";
    }

}
