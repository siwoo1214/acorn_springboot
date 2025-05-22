package com.example.day07PracSession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/loginForm")
    public String loginForm(@CookieValue(name="userId", required = false, defaultValue = "")String id,
                            Model model){

        model.addAttribute("id",id);
        System.out.println(id);

        return "loginForm";
    }

    @PostMapping("/loginForm")
    public String login(@ModelAttribute User user,
                        HttpServletResponse response,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes){

        System.out.println(user.getId());
        System.out.println(user.getPw());
        System.out.println(user.isRmid());

        if(!check(user)){
            return "loginForm";
        }
        //인증 완료된 후 세션저장소에 로그인 정보 저장하기

        HttpSession session = request.getSession();

        //사용자 세션을 얻어옴
        //기존에 사용자 세션이 있으면 있는 세션이 변환
        //세션이 없다면 새로운 세션을 반환

        redirectAttributes.addFlashAttribute("id",user.getId());
        if(user.isRmid()){
            Cookie cookie = new Cookie("userId",user.id);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("userId",user.id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        return "redirect:/home";
    }

    private boolean check(User user){
        if(user.getId().equals(user.getPw())){
            return true;
        } else{
            return false;
        }
    }
}
