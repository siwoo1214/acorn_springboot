package com.example.tranEx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService service;

    /*
    * 회원가입 시 포인트 적립
    * 외원가입
    *  - 회원테이블에 등록
    *  - 포인트 테이블에 회원의 포인트 등록
    *  => 하나의 논리적 단위로 묶어서 모두 수행되거나 모두 수행되지 않게 하기 (Transaction)
    * */

    @GetMapping("/join")
    public String  join(){

        Member  member= new Member();
        member.setId("acorn");
        member.setName("홍길동");


        service.회원가입포인트적립(member);
        return "ok";
    }

}
