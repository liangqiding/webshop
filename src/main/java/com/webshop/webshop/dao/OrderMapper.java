package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
//   生产订单
    int InsOrder(Order order);
//    一对多查询
    List<Order> SelectOrderAndCart(Order order);
//    更新订单
    int UdpOrder(Order order);
}
