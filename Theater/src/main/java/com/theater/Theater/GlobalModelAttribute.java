package com.theater.Theater;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

//얘는 모든 템플릿에서 사용할 수 있는 값을 설정해주는거임
@ControllerAdvice
public class GlobalModelAttribute {

    @ModelAttribute
    public void adviceLoginInfo(Model model, HttpSession session){
        User loggedUser = (User) session.getAttribute("loginUser");
        if(loggedUser!=null){
            model.addAttribute("user",loggedUser);
        }
    }
}
