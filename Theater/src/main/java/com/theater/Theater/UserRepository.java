package com.theater.Theater;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    SqlSession session;

    //이거로 아이디, 비번 맞는 유저를 db에서 찾아옴
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