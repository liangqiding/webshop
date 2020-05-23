package com.webshop.webshop.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webshop.webshop.dao.CartMapper;
import com.webshop.webshop.dao.OrderMapper;
import com.webshop.webshop.dao.ProductMapper;
import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.Order;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2018-2020
 * FileName: OrderServiceImp
 * Author:
 * Date:     2020/2/21 14:50
 * Description: 生成订单
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public int InsOrder(Order order) {
        return orderMapper.InsOrder(order);
    }

    @Override
    public PageInfo<Order> SelectOrderAndCart(Integer pageNum, Integer pageSize, Order order) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.SelectOrderAndCart(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        return orderPageInfo;
    }

    //生成订单
//    添加事物管理 保证事物正常 避突发情况
    @Transactional
    @Override
    public int DoOrder(Order order, Cart cart, String cart_state, Integer cart_id, Integer u_id) {
        Cart cartEach = new Cart();
        //        1.//更新清单状态  支付中--变为-> 待收货
        int i1 = 0;
        if (cart_state.equals("购物车支付中")) {
//            更新销量
            int a = DosaveP_sum("购物车支付中", cart);
            //            开始调用生成订单方法
            cartEach.setU_id(u_id);
            cart.setCart_state("购物车支付中");
            List<Cart> carts = cartMapper.Sel_CartCar_All_state_uid(cartEach);
            eachCart(carts, cart, order,"购物车");
        } else if (cart_state.equals("多个支付中")) {
//            多个订单一起支付
            //            更新销量
            int a = DosaveP_sum("多个支付中", cart);
//            开始调用生成订单方法
            cartEach.setU_id(u_id);
            cartEach.setCart_state("支付中");
            List<Cart> carts = cartMapper.Sel_CartCar_All_state_uid(cartEach);
            eachCart(carts, cart, order,"支付");
        }else if (cart_state.equals("单个支付中")) {
//            单个订单支付 通过id 直接更新
            cart.setCart_id(cart_id);
            i1 = cartMapper.UpdCartByStateAndU_idAndC_id(cart);
            //            更新销量
            int a = DosaveP_sum("支付中", cart);
            //       2.生成总订单  负责控制物流，计算多个购物清单总价
            int i = orderMapper.InsOrder(order);
        }

//        3.更新商品库存及销量情况
        return i1 + 1;
    }

    @Override
    public int UdpOrder(Order order) {
        return orderMapper.UdpOrder(order);
    }

    //    更新销量
    private int DosaveP_sum(String s, Cart cart) {
//        普通订单
        List<Cart> carts = null;
        cart.setCart_state(s);
        //        购物车订单
        if (s.equals("购物车支付中")) {
            carts = cartMapper.Sel_CartCar_All_state_uid(cart);
        } else {
            carts = cartMapper.SelCartByU_idAndState(cart);
        }
        try {
            for (Cart c : carts
            ) {
                //            获取商品id
                Integer cart_p_id = c.getCart_p_id();
                //            获取清单购买数量
                Integer cart_sum = c.getCart_sum();
                //            获取原商品
                Product product1 = productMapper.SelProductByPid(cart_p_id);
                //            更新商品销量
                Product product = new Product();
                product.setP_id(cart_p_id);
                product.setP_sum(product1.getP_sum() + cart_sum);
                int i = productMapper.UpdProById(product);
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


    //遍历清单 针对一次购买多个商品，生成订单   根据不同卖家，生成对应卖家的订单。方便卖家发货
    private void eachCart(List<Cart> carts, Cart cartA, Order order,String msg) {
        //        设置Order_id
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        cartA.setCart_state("待发货");
//        建立map表 键为 卖家id 值为 清单ID
        HashMap<Integer, String> hashMap = new HashMap<>();
        int sum = 0;
        for (Cart c :
                carts) {
            Integer seller_id = c.getSeller_id();
            Integer cart_id = c.getCart_id();
            if (sum == 0) {
//                累计 避免重复 此if块 只运行一次
                sum++;
                //       1.先生成总订单  负责控制物流，计算多个购物清单总价
                order.setOrder_uuid(uuid);
                order.setOrder_cardid(seller_id);
                int i = orderMapper.InsOrder(order);
                //           2. 购物车订单  通过  id更新
                cartA.setCart_id(cart_id);
                cartA.setCart_order_id(uuid);
                if (msg.equals("购物车")){
                    cartMapper.UpdCart_Car(cartA);
                }else {
                    cartMapper.UpdCartByStateAndU_idAndC_id(cartA);
                }
//                把卖家id 和订单id 存入map
                hashMap.put(seller_id, uuid);
//                sum累计 避免重复
            }
            for (Integer key : hashMap.keySet()
            ) {
//                判断是否为不同卖家
                if (key == seller_id) {
//                      绑定清单
//                    更新 清单
                    String s = hashMap.get(seller_id);
                    cartA.setCart_order_id(s);
                    cartA.setCart_id(cart_id);
                    if (msg.equals("购物车")){
                        cartMapper.UpdCart_Car(cartA);
                    }else {
                        cartMapper.UpdCartByStateAndU_idAndC_id(cartA);
                    }
                } else {
//                    生成新 order
                    //       1.先生成总订单  负责控制物流，计算多个购物清单总价
                    order.setOrder_uuid(uuid + cart_id);
                    order.setOrder_cardid(seller_id);
                    int i = orderMapper.InsOrder(order);
                    hashMap.put(seller_id, uuid + cart_id);
//                    绑定清单
                    //                    更新 清单
                    String s = hashMap.get(seller_id);
                    cartA.setCart_order_id(s);
                    cartA.setCart_id(cart_id);
                    if (msg.equals("购物车")){
                        cartMapper.UpdCart_Car(cartA);
                    }else {
                        cartMapper.UpdCartByStateAndU_idAndC_id(cartA);
                    }
                }
            }
        }
    }
}
