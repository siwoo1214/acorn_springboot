package com.example.day06Prac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("/test1")
    public String test1(Model model){

        List<Acorn> list = new ArrayList<>();
        list.add(new Acorn("acorn1","1234","윤현기"));
        list.add(new Acorn("acorn2","0712","이동우"));
        list.add(new Acorn("acorn3","1214","최지태"));

        model.addAttribute("list",list);

        return "thymeView1";
    }
}
