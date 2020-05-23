package com.webshop.webshop.controller.main.Order;

import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.CartServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: CartOutController
 * Author:
 * Date:     2020/2/22 9:42
 * Description:跳转购物车结算
 */
@Controller
public class CartOutController {
    @Autowired
    private CartServiceImp cartServiceImp;
    //    跳转购物车结算
    @RequestMapping("/cartout")
    public String CheckOut() {
        return "main/CartOut";
    }

    //    查询购物车支付列表 多个数据
    @RequestMapping("/SelCartOut")
    @ResponseBody
    public List<Cart> SelCartOut() {
        Cart cart = new Cart();
       int userU_id=0;
         userU_id = getUserU_id();
         if (userU_id<1){
             return null;
         }
        cart.setU_id(userU_id);
        List<Cart> cart1 = cartServiceImp.Sel_CartCar_All_state_uid(cart);
        return cart1;
    }

    //    封装获取u_id方法
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
