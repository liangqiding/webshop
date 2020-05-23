package com.webshop.webshop.controller.main.Order;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.webshop.webshop.pojo.Address;
import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.Order;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.AddressServiceImp;
import com.webshop.webshop.service.imp.CartServiceImp;
import com.webshop.webshop.service.imp.OrderServiceImp;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2018-2020
 * FileName: OrderController
 * Author:
 * Date:     2020/2/20 16:21
 * Description: 生成订单
 */
@Controller
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;
    @Autowired
    private AddressServiceImp addressServiceImp;
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private CartServiceImp cartServiceImp;

    //支付成功
    @RequestMapping("/order")
    public String CheckOut2() {
        return "main/Order";
    }

    //
    @RequestMapping("/fahuo")
    @ResponseBody
    public String fahuo(Integer id){
        Order order = new Order().setId(id).setState("已发货");
        int i = orderServiceImp.UdpOrder(order);
        System.out.println(i);
        return "发货成功";
    }
    //
    @RequestMapping("/shouhuo")
    @ResponseBody
    public String shouhuo(Integer id,String state){
        Order order = new Order().setId(id).setState(state);
        int i = orderServiceImp.UdpOrder(order);
        System.out.println(i);
        return state+"，成功！";
    }

    //    生成订单
    @RequestMapping("/DoOrder")
    @ResponseBody
    public String DoOrder(Integer cart_id, String cart_state) {
        Integer u_id = 0;
        u_id = getUserU_id();
        if (u_id == 0) {
            return "请先登录";
        }
//        根据id查询用户地址
        Address address = addressServiceImp.SelAddressByuidOne(u_id);
//        初始化Order对象
        Order order = new Order();
/*
*  注意   真实情况是可以有多个卖家 每个卖家可以看到自己的商品的售卖情况。。。
* 分析：  卖家 ----商品  是一对多关系
* 分析：  卖家 ----订单----买家  是一对多对一 关系
* 复杂度分析：   假设 某买家 同时购买了卖家A 和卖家B的多个商品    一起结算时 会生成多个订单对应多个卖家
* */
//        设置Order_id
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        order.setOrder_uuid(uuid);
        //    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        order.setDate(time);
//        绑定用户uid
        order.setU_id(u_id);
//        绑定地址信息
        order.setName(address.getName());
        order.setAddress(address.getAddress());
        order.setPhone(address.getPhone());
//        设置订单状态
        order.setState("待发货");
        //        统计总价
        order.setOrder_price(getSumPrice(cart_id, cart_state));
//        绑定待支付清单
        Cart cart = new Cart();
        cart.setU_id(u_id);
        cart.setCart_state("待发货");
        cart.setCart_order_id(uuid);
        //        生成总订单 ====》保存至数据库
        int i = orderServiceImp.DoOrder(order, cart, cart_state, cart_id,u_id);
        if (i>=1){
            return "success";
        }else
            return "结算失败";
    }

    //    统计总价
    private double getSumPrice(Integer cart_id, String cart_state) {
        //    查询该用户所有待购物车支付订单
        Cart cart = new Cart();
        if (cart_id != null) {
//            单个支付 计算单个订单总价
            cart.setCart_id(cart_id);
        } else if (cart_state.equals("多个支付中")) {
//            多个支付 计算多个订单总价
            cart.setCart_state("支付中");
        } else {
//            购物车支付  计算购物车总价
            cart.setCart_state(cart_state);
        }
        cart.setU_id(getUserU_id());
        List<Cart> cart1 = cartServiceImp.SelCartByU_idAndState(cart);
        Double cart_order_price = 0.0;
        for (Cart c : cart1
        ) {
            cart_order_price += c.getCart_order_price();
        }
        System.out.println("总价为：" + cart_order_price);
        return cart_order_price;
    }


    //    //    封装获取u_id方法
    private Integer getUserU_id() {
        Integer u_id = 0;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            u_id = user.getId();
        } catch (Exception e) {
            return 0;
        }
        return u_id;
    }
}
