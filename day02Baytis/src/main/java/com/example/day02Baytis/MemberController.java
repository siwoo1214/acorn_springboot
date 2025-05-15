package com.example.day02Baytis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class MemberController {


    @Autowired
    MemberService  memberService;



    @GetMapping("/members123")
    public  String   getMembers( Model model){
        List<Member2> list = memberService.getMembers();
        System.out.println( list);
        model.addAttribute("list" , list);
        return  "memberlist";
    }



    //등록화면

    @GetMapping("/form")
    public  String   form(){
        return "formView";
    }


    //등록하기
    @PostMapping("/formProc")
    public  String formProc( @ModelAttribute Member member){  //생성자, 세터
         System.out.println( member);
         //
        memberService.registerMember(member);
        return "ok";
    }



}
