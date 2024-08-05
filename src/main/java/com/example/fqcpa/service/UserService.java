package com.example.fqcpa.service;

import com.example.fqcpa.pojo.User;

public interface UserService {

    // query username by username
    User findByUserName(String username);

    void register(String username, String password);
}
