package com.example.day05PracRestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberAPIController {

    //@ResponseBody
    @GetMapping("/members")
    public List<Member> memberList(){
        List<Member> list = new ArrayList<>();
        list.add(new Member("acorn1","브래드피트","bread@naver.com"));
        list.add(new Member("acorn2","음바페","mbape@naver.com"));
        list.add(new Member("acorn3","트래비스스콧","scott@naver.com"));

        return list;
    }

    //회원등록하기
    //@ResponseBody
    @PostMapping("/members")
    public String memberRegister(@RequestBody Member member){
        System.out.println(member.getId());
        System.out.println(member.getName());
        System.out.println(member.getEmail());

        //service, repository => 데이터베이스에 등록하기


        return "성공";
    }

    //해당하는 고객의 정보 조회하기
    //자바스크립트  /members/siwoo 에서 siwoo를 이렇게 받아온다
    //@ResponseBody  //객체 응답하기 위해서 꼭 붙여야함
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable(name="id") String id){
        System.out.println(id);
        //id에 대한 고객정보 조회하기, service, repository를 다녀와야함
        Member m = new Member("acorn1","브래드피트","bread@naver.com");

        return m;
    }

    //@ResponseBody   //데이터가 반환되니까
    @DeleteMapping("/members/{id}")
    public String memberDelete(@PathVariable(name="id") String id){
        System.out.println(id);
        //service -> repository -> 데이터베이스 삭제

        return "성공";
    }
}
