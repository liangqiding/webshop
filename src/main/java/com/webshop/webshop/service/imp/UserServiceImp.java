package com.webshop.webshop.service.imp;

import com.webshop.webshop.dao.UserMapper;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2018-2020
 * FileName: UserServiceImp
 * Author:
 * Date:
 * Description:
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private  UserMapper userMapper;
// 登录
    @Override
    public User SelectUserByUsername(String username) {
        return userMapper.SelectUserByUsername(username);
    }
//注册
    @Override
    public int InsterUser(User user) {
        return userMapper.InsterUser(user);
    }

    @Override
    public int UpdUserByUsername(User user) {
        return userMapper.UpdUserByUsername(user);
    }
}
