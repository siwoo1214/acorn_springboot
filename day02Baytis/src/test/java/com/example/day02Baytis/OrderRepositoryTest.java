package com.example.day02Baytis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {


    @Autowired
    OrderRepository repository;



    @Test
    public void test(){
        int size  =repository.selectAll().size();
        assertTrue( size>=1);
    }

}