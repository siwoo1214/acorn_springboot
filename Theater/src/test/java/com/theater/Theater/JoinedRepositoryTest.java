package com.theater.Theater;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoinedRepositoryTest {

    @Autowired
    JoinedRepository repo;

    public void test(){
        int size = repo.movies().size();
        assertTrue(size>=1);
    }

    @Test
    public void test2(){
        int size = repo.joinedList().size();
        assertTrue(size>=1);
    }
}