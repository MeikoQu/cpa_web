package com.example.fqcpa.mapper;

import com.example.fqcpa.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUserName(String username);

    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{encryptedPassword})")
    void add(String username, String encryptedPassword);
}
