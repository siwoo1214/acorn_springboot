package com.dbconnection.dbconnecPrac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardRepository repo;

    @GetMapping("/allcontents")
    public String showcontents(@ModelAttribute searchIndex si,Model model){
        List<Board> list = repo.selectedContents(si);
        model.addAttribute("list",list);
        return "contents";
    }

    @GetMapping("/allshow")
    public String testing(Model model){
        List<Board> list = repo.contents();
        model.addAttribute("list1",list);
        return "allContents";
    }

    @GetMapping("/insertBoard")
    public String insertBoard(@ModelAttribute Board Board, Model model){
        //여기다가는 추가하는 기능 매퍼에 만들고 불러와기
        return "insertForm";
    }
}
