package com.example.fqcpa.controller;

import com.example.fqcpa.mapper.UserMapper;
import com.example.fqcpa.pojo.Result;
import com.example.fqcpa.pojo.User;
import com.example.fqcpa.service.UserService;
import com.example.fqcpa.utils.PasswordEncryptor;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(
            @RequestParam @Pattern(regexp = "^[a-zA-Z0-9]{5,16}$") String username,
            @RequestParam @Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{5,16}$") String password) {

        // query user
        User u = userService.findByUserName(username);
        if (u == null) {
            // register
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("That username is taken.");
        }
    }

    public Result<String> login(
            @RequestParam @Pattern(regexp = "^[a-zA-Z0-9]{5,16}$") String username,
            @RequestParam @Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{5,16}$") String password){
        //query this username
        User u = userService.findByUserName(username);
        if(u == null){
            return Result.error("That username is not exist.");
        }
        // check if password is correct
        if(PasswordEncryptor.encryptPassword(password).equals(u.getPassword())){
            return Result.success("");
        }
        // successful login
        return Result.error("Password is incorrect.");
    }
}