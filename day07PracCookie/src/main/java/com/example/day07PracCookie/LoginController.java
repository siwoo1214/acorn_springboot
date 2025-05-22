package com.example.day07PracCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginForm")
    public String loginForm(@CookieValue(name = "id", required = false,defaultValue = "")String id,
                            Model model){
        model.addAttribute("id",id);
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "id",required = false) String id,
                        @RequestParam(name = "pw",required = false)String pw,
                        @RequestParam(name = "rmid",required = false)boolean rmid,
                        HttpServletResponse response){

        System.out.println(id);
        System.out.println(pw);
        System.out.println(rmid);

        //실패하면 return "loginForm"


        if(rmid){  //id 기억 하기
            System.out.println("아이디 기억 하기");
            //쿠키 생성
            //쿠키 응답
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(60*60*24);
            //쿠키 응답을 반드시 해줘야함
            response.addCookie(cookie);
        }else{
            //id 기억 안하기 (쿠키를 삭제할 때는 동일한 이름으로 쿠키를 생성한 다음
            // 만료시간을 0으로 설정한다음 다시 쿠키를 응답하는 방법을 사용
            //쿠키 생성, 이전에 생성한 쿠키와 동일한 이름으로 생성
            //쿠키 응답
            System.out.println("아이디 기억 안하기");

            //삭제하려고 다시 만드는 거면 이름을 반드시 똑같이 만들어줘야함
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/home";
    }

}
