package com.webshop.webshop.controller.main;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.ProductServerImp;
import com.webshop.webshop.service.imp.UserServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2018-2020
 * FileName: Index
 * Author:
 * Date:     2020/2/18 9:07
 * Description:
 */
@Controller
public class MainIndex {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    UserServiceImp userServiceImp;
    //    跳转主页
    @RequestMapping("/index")
    public String index() {
        return "main/index";
    }

    //        获取用户信息
    @RequestMapping("/getusers")
    @ResponseBody
    public User getusers() {
        String username=null;
        User user=new User();
        try {
            user = (User) SecurityUtils.getSubject().getPrincipal();
           username = user.getUsername();
        } catch (Exception e) {
            return null;
        }
        User user1 = userServiceImp.SelectUserByUsername(username);
        return user1;
    }
//    String p_name,Integer p_classid
//     模糊及分类查询
@RequestMapping("/SelProductBymohu")
@ResponseBody
public Boolean SelProductBymohu(HttpSession session, String p_name, Integer p_classid) {
        session.setAttribute("p_name",p_name);
        session.setAttribute("p_classid",p_classid);
    return true;
}
    //     分页
    @RequestMapping("/Limit")
    @ResponseBody
    public PageInfo<Product> Limit(HttpSession session,Integer pageNum) {
        if (pageNum==null){
            pageNum=1;
        }
        session.setAttribute("pageNum",pageNum);
        Product product = new Product();
//        查找结果分页
        try {
            String p_name = (String) session.getAttribute("p_name");
            if (p_name != null)
                product.setP_name(p_name);
        } catch (Exception e) {
        }
        try {
            Integer p_classid = (Integer) session.getAttribute("p_classid");
            if (p_classid != null&&p_classid!=0) {
                product.setP_classid(p_classid);
            }
        } catch (Exception e) {
        }
        PageInfo<Product> productPageInfo = productServerImp.SelAllProduct(pageNum, 4, product);
        return productPageInfo;
    }

    @RequestMapping("/getClassId")
    @ResponseBody
    public Integer getClassId(HttpSession session) {
        try {
            Integer p_classid = (Integer) session.getAttribute("p_classid");
            if (p_classid != null&&p_classid!=0) {
               return p_classid;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
