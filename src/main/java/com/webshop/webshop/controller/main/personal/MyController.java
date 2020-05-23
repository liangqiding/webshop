package com.webshop.webshop.controller.main.personal;

import com.webshop.webshop.dao.UserMapper;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.UserServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2018-2020
 * FileName: MyController
 * Author:
 * Date:     2020/2/22 13:28
 * Description:我的个人信息
 */
@Controller
public class MyController {
    @Autowired
    UserServiceImp userServiceImp;

    //我的个人信息
    @RequestMapping("/my")
    public String CheckOut2() {
        return "main/personal/my";
    }

    //获取个人信息
    @RequestMapping("/GetUser")
    @ResponseBody
    public User GetUser() {
        String userUsername = getUserUsername();
        if (userUsername.equals("error")) {
            return null;
        }
        User user = userServiceImp.SelectUserByUsername(userUsername);
        return user;
    }

    //更新个人信息
    @RequestMapping("/UdpUser")
    @ResponseBody
    public String UdpUser(User user) {
        String userUsername = getUserUsername();
        if (userUsername.equals("error")) {
            return "保存失败";
        }
        user.setUsername(userUsername);
        int i = userServiceImp.UpdUserByUsername(user);
        if (i >= 0) {
            return "保存成功";
        } else
            return "保存失败";
    }

    //    封装获取u_id方法
    private String getUserUsername() {
        String username = null;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            username = user.getUsername();
        } catch (Exception e) {
            return "error";
        }
        return username;
    }
}
