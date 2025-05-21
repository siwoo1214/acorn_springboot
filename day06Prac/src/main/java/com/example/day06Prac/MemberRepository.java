package com.example.day06Prac;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession session;

    public List<Member> selectAll(){
        List<Member> list = session.selectList("a.selectAll");
        return list;
    }

    public List<Member> selectPage(int currentPage,int pageSize){
        //현재 페이지에 대한 시작, 끝 구하기 (grpSize 정보가 필요함)

        //currentPage = 1;
        //pageSize = 5로 가정
        // start = 1
        // end = 5

        // currentPage = 3;
        //pageSize = 5로 가정
        // start = 11
        // end = 15

        int start = (currentPage-1)*pageSize+1;
        int end = currentPage*pageSize;

        // 매개변수로 객체를 사용해야한다
        Map<String,Integer> pageInfo = new HashMap<>();
        pageInfo.put("start",start);
        pageInfo.put("end",end);

        return session.selectList("a.selectPage",pageInfo);
    }

    public int countAll(){
        return session.selectOne("a.selectCount");
    }
}
