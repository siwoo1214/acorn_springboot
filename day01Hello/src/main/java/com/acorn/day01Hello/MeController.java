package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeController {

    @GetMapping("/me")
    public String me(Model model){
        model.addAttribute("data","asdasdasd");
        return "me";
    }
}
