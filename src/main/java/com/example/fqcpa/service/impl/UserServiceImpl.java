package com.example.fqcpa.service.impl;

import com.example.fqcpa.mapper.UserMapper;
import com.example.fqcpa.pojo.User;
import com.example.fqcpa.service.UserService;
import com.example.fqcpa.utils.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        // password encryption
        String encryptedPassword = PasswordEncryptor.encryptPassword(password);
        // add new user
        userMapper.add(username, encryptedPassword);
    }
}
