package com.webshop.webshop.controller.main.Order;

import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.CartServiceImp;
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
 * FileName: CheckOutController
 * Author:
 * Date:     2020/2/21 10:56
 * Description: 单个购物清单结算页面
 */
@Controller
public class CheckOutController {
    @Autowired
    private CartServiceImp cartServiceImp;
    @Autowired
    private ProductServerImp productServerImp;

    //    待结算页面
    @RequestMapping("/CheckOut")
    public String CheckOut() {
        return "main/CheckOut";
    }
    //    单商品结算页面
    @RequestMapping("/CheckOut_pay")
    public String CheckOut_pay() {
        return "main/CheckOut_pay";
    }

    //    查询支付列表 单个数据
    @RequestMapping("/SelCartOne")
    @ResponseBody
    public Cart SelCartOne() {
        Cart cart = new Cart();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        cart.setU_id(user.getId());
//        cart.setCart_state("待支付");
//    查询该用户所有待支付订单
        List<Cart> cart1 = cartServiceImp.SelCartByU_idAndState(cart);
//        遍历出最新生成的订单 id越大 订单越新
        Cart newcart = new Cart();
        Integer cart_id1=0;
        for (Cart c :cart1
        ) {
           int cart_id2 = c.getCart_id();
           if (cart_id2>cart_id1){
               cart_id1=cart_id2;
               newcart=c;
           }
        }
        return newcart;
    }
    //    查询待支付列表 多个数据
    @RequestMapping("/SelCart")
    @ResponseBody
    public List<Cart> SelCart() {
        Cart cart = new Cart();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        cart.setU_id(user.getId());
//        cart.setCart_state("待支付");
//    查询该用户所有待支付订单
        List<Cart> cart1 = cartServiceImp.SelCartByU_idAndState(cart);
        return cart1;
    }
    //    /SumPrice  计算总价格   支付状态分为：待支付->支付中->待发货->代收货->待评价->完成交易
    @RequestMapping("/SumPrice")
    @ResponseBody
    public Double SumPrice(Integer cart_id,String cart_state,String all) {
        Cart cart = new Cart();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        cart.setU_id(user.getId());
//        全选中，进入支付中 或者回到待支付状态
              Cart cart_all = new Cart();
        if (all!=null&&all.equals("yes")){
            cart_all.setU_id(user.getId());
            cart_all.setCart_state(cart_state);
            cartServiceImp.UpdCartByid(cart_all);
        }else if(cart_id!=null){//选中单个
            cart_all.setCart_state(cart_state);
            cart_all.setCart_id(cart_id);
            cartServiceImp.UpdCartByid(cart_all);
        }
        cart.setCart_state("支付中");
//    查询该用户所有待支付订单
        List<Cart> cart1 = cartServiceImp.SelCartByU_idAndState(cart);
        Double cart_order_price=0.0;
        for (Cart c : cart1
        ) {
            cart_order_price += c.getCart_order_price();
        }
        System.out.println("总价为："+cart_order_price);
        return cart_order_price;
    }

    //    生产cart 单个购物清单
    @RequestMapping("/pay")
    @ResponseBody
    public String creaddress(Integer cart_sum,Integer p_id) {
        System.out.println("p_id="+p_id+"   cart_sum="+cart_sum);
        int u_id=0;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            u_id = user.getId();
        } catch (Exception e) {
            return "请先登录";
        }
//        判断库存
        Product product1 = productServerImp.SelProductByPid(p_id);
        if (cart_sum>product1.getP_keep()){
            return "库存不足";
        }
//        更新库存
        Product product2 = new Product();
        product2.setP_keep(product1.getP_keep()-cart_sum);
        product2.setP_id(p_id);
        int i1 = productServerImp.UpdProById(product2);

//        创建订单
        Cart cart = new Cart();
        //    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
        cart.setCart_date(time);
//        绑定商品ID
        cart.setCart_p_id(p_id);
//        绑定购买数量
        cart.setCart_sum(cart_sum);
//        通过ID查询出商品
        Product product = productServerImp.SelProductByPid(p_id);
//        绑定商品封面
        cart.setCart_img(product.getP_img());
//        绑定商品名
        cart.setCart_p_name(product.getP_name());
//        绑定商品价格
        cart.setCart_p_price(product.getP_price());
//        绑定用户id
        cart.setU_id(u_id);
//        绑定价格  优惠默认 9折
        cart.setCart_order_price(product.getP_price()*0.9*cart_sum);
//        设置订单状态
        cart.setCart_state("支付中");
//        设置uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        cart.setCart_uuid(uuid);
        //        设置卖家ID
        cart.setSeller_id(product.getP_userid());

        int i = cartServiceImp.InsCart(cart);
        System.out.println("购物清单已生成");
        return uuid;
    }
}
