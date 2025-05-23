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
    public String home(HttpSession session,Model model){
        String id = (String)session.getAttribute("id");
        model.addAttribute("id",id);
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
                        HttpSession session){

        System.out.println(user.getId());
        System.out.println(user.getPw());
        System.out.println(user.isRmid());

        session.setAttribute("id",user.getId());

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

    @GetMapping("/logOut")
    public String logout(HttpServletRequest request){

        //세션정보 삭제하기
        HttpSession session = request.getSession(false);
        session.invalidate();

        //세션에 저장된 값중 특정값만 지우고싶으면
        //session.removeAttribute("USERID");

        return "redirect:/home";
    }
}
