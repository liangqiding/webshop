package com.webshop.webshop.controller.main.personal;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.pojo.Order;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.OrderServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: LogController
 * Author:
 * Date:     2020/2/22 13:57
 * Description:
 */
@Controller
public class OrderLogController {
    @Autowired
    private OrderServiceImp orderServiceImp;
    //我的订单
    @RequestMapping("/OrderLog")
    public String CheckOut2() {
        return "main/personal/orderLog";
    }


    //    查询出所有订单
    @RequestMapping("/SelOrderAndCart")
    @ResponseBody
    public List<Order> SelOrderAndCart() {
        Order order = new Order();
        order.setU_id(getUserU_id());
        PageInfo<Order> orderPageInfo = orderServiceImp.SelectOrderAndCart(1, 50, order);
        List<Order> list = orderPageInfo.getList();
        System.out.println("List<Order>:"+list);
        return list;
    }


    //    //    封装获取u_id方法
    private Integer getUserU_id(){
        Integer u_id=0;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            u_id = user.getId();
        } catch (Exception e) {
            return 0;
        }
        return u_id;
    }
}
