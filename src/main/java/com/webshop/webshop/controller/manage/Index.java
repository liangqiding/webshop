package com.webshop.webshop.controller.manage;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @version 1.0
 * @date 2020/2/17/017 13:25
 * @descriptio
 */
@Controller
public class Index{
//    跳转主页
    @RequestMapping("/")
    public String Test() {
        return "main/index";
    }
    //    跳转登录页面
    @RequestMapping("/login")
    public String login() {
        return "login/index";
    }
    //    跳转登录页面
    @RequestMapping("/logout")
    public String logout() {
        Subject lvSubject= SecurityUtils.getSubject();
        lvSubject.logout();
        return "login/index";
    }

}
