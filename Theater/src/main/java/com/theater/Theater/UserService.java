package com.theater.Theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String id, String pw) {
        return repo.login(id, pw);
    }

    public void join(User user){
        repo.join(user);
    }
}