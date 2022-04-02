package com.study.service;

import com.study.pojo.User;

public interface UserService {
//用户登录，根据用户名和密码查询用户
    public User checkUser(String username, String password);
}
