package com.dbconnection.dbconnecPrac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    SqlSession session;

    public List<Board> contents(){
        return session.selectList("a.SelectAll");
    }

    public int insertContent(Board board){
        return session.insert("a.insert",board);
    }

    public List<Board> selectedContents(searchIndex si){
        return session.selectList("a.selectedBoard", si);
    }
}
