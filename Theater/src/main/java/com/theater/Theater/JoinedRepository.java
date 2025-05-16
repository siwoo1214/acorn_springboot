package com.theater.Theater;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JoinedRepository {

    @Autowired
    SqlSession session;

    public List<Movie> movies(){
        return session.selectList("a.allM");
    }

    public List<JoinedDTO> joinedList(){
        return session.selectList("a.allMovies");
    }

    public List<JoinedDTO> selectedMovies(SearchCondition condition){
        List<JoinedDTO> list = session.selectList("a.selectMovie",condition);
        List<JoinedDTO> newList = new ArrayList<>();

        for(JoinedDTO tmp : list){
            String[] date_time = tmp.date_time.split("-");
            tmp.setDate_time(date_time[2]+"일");
            newList.add(tmp);
        }
        return newList;
    }
}
