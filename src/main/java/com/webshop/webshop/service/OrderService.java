package com.webshop.webshop.service;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.pojo.Cart;
import com.webshop.webshop.pojo.Order;
public interface OrderService {
    int InsOrder(Order order);
    PageInfo<Order> SelectOrderAndCart(Integer pageNum, Integer pageSize, Order order);
    int DoOrder(Order order,Cart cart,String cart_state,Integer cart_id,Integer u_id);
    int UdpOrder(Order order);
}
