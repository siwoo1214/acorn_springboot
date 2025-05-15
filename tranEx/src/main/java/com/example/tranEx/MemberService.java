package com.example.tranEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {


    @Autowired
    MemberRepository  memberRepository;
    @Autowired
    PointRepository pointRepository;



    /*

       논리적단위 :
       모두 수행되거나 수행되지않게 하기

     */



    // 트랜젝션으로 묶으면 기능중에 하나라도 잘못되면 매소드가 작동하지 않음
    //
    @Transactional
    public void  회원가입포인트적립( Member member){

        //회원가입
        memberRepository.memberRegistry(member);

//        if(true) throw new RuntimeException(" 예외 발생시킴");

        //포인트등록
        PointDTO point  = new PointDTO();
        //id는 자동생성되게 table에서 설정해놨기 때문에 따로 설정 안해줘도 된다
        point.setMemberId(member.getId());
        point.setAmount(10000);


        pointRepository.pointRegistry(point);


    }
}
