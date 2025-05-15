package com.example.day02Baytis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession  session;



    //전체조회
    public List<Member>  selectAll(){
       return  session.selectList("a.selectAll");
    }


    //등록
    public  int  insert( Member member){
        return session.insert( "a.insert" , member);
    }




    //조회

    public   List<Member2>  selectAll2(){
        return  session.selectList("a.selectAll2");
    }



    public   List<Member2>  selectAll3(){
        return  session.selectList("a.selectAll3");
    }


}
