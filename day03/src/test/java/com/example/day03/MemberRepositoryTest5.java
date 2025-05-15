package com.example.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class MemberRepositoryTest5 {


    @Autowired
    MemberRepository  repository;



    @Test
    public  void  tesrt(){

        List<String> list  = new ArrayList<>();
        list.add("acorn");
        list.add("acorn3");
        list.add("acorn4");



        int size  =repository.selectSearch(list).size();
        assertTrue(size==3);


    }
}