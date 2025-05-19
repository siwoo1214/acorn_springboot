package com.theater.Theater;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    SqlSession session;

    //레포지토리가 앵간하면 비지니스 로직을 다룬다
    //이거로 아이디, 비번 맞는 유저를 db에서 찾아옴
    //mybatis는 객체기반으로 데이터를 처리한다는 점을 알아두어야한다.
    //그래서 데이터가 오고 갈 때 객체를 기반으로 파라미터 타입을 추가한다.
    public User login(String id, String pw) {
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        return session.selectOne("userMapper.login", user);
    }

    public void join(User user) {
        session.insert("userMapper.insertUser", user);
    }
}