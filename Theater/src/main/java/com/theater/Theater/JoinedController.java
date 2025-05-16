package com.theater.Theater;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class JoinedController {

    @Autowired
    JoinedRepository repo;

    @GetMapping("/queryMovie")
    public String selectMovie(@ModelAttribute SearchCondition condition,
                              Model model,
                              HttpSession session) {

        // 세션에 사용자 정보가 없으면 로그인 페이지로 리다이렉트
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login";
        }

        if (condition.getCondition() != null) {
            List<JoinedDTO> list = repo.selectedMovies(condition);
            model.addAttribute("list", list);
        }

        return "home";
    }

}
