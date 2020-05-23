package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@ToString
@Accessors(chain = true)
public class Order {
    private Integer id;
//客户地址信息
    private String name;
    private String address;
    private String phone;
//    生成日期
    private String date;
//    商品id
    private Integer p_id;
//
    private String order_uuid;
//    订单总价
    private double order_price;
//    订单交易状态
    private String state;
//    物流状态
    private String post;
//    物流单号
    private String post_id;
//购买总数
    private Integer sum;

//卖家ID
    private Integer order_cardid;
//买家id
    private Integer u_id;

    private List<Cart> cartList;
}