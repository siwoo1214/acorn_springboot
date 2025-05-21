package com.example.day06Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberRepository repo;

    @GetMapping("/memberList")
    public String  getMembers(Model model){

        List<Member> list  = repo.selectAll();
        model.addAttribute("list" , list);

        return "memberListAll";
    }

    //안줬으면 list?currentPage=1
    //list?currentPage=3
    @GetMapping("/list")
    public String getMembersPage(
            @RequestParam(name="currentPage", required = false, defaultValue = "1") int currentPage,
            Model model){

        System.out.println(currentPage);
        int pageSize = 3;
        int grpSize = 2;  //[1] [2] [3] [4] [5]
        int totalCount = 0;

        totalCount = repo.countAll();

        PageHandler ph = new PageHandler(currentPage,pageSize,grpSize,totalCount);
        System.out.println("PageHandler = "+ph);

        List<Member> list = repo.selectPage(currentPage,pageSize);
        model.addAttribute("pageHandler",ph);
        model.addAttribute("list",list);

        return "list";
    }

}

