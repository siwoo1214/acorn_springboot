package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {


    @Autowired
    MemberService service;

    @GetMapping("/memberSearch")
    public  String   searchMember(  @RequestParam(name="userid") List<String> userid  , Model model){

        System.out.println(  userid);
        // [ acorn , acorn3, acorn4]
        //서비스로부터 해당고객정보 리스트로 얻어오기
        //모델에 저장

        List<Member> list  = service.getSearchMember(userid);

        model.addAttribute("list", list);
        //뷰응답
        return   "memberList";
    }


}
