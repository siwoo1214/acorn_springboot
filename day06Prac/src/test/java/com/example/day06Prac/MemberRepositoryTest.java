package com.example.day06Prac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repo;

    @Test
    public void test(){
        List<Member> list = repo.selectAll();
        assertTrue(list.size()>=1);
    }

    @Test
    public void test1(){
        List<Member> list = repo.selectPage(2,3);
        assertTrue(list.size()>=1);
    }

    @Test
    public void test2(){
        int cnt = repo.countAll();
        assertTrue(cnt==12);
    }
}