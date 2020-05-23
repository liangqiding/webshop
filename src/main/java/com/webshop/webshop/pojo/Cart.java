package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Copyright (C); 2018-2020
 * FileName: Cart
 * Author:
 * Date:     2020/2/19 8:13
 * Description: 购物车
 */
@Data
@ToString
public class Cart {
    private Integer cart_id;
//    商品名
    private String cart_p_name;
//    生产日期
    private String cart_date;
//    订单id
    private Integer cart_p_id;
//    购物车单笔总价格
    private Double cart_order_price;
//    结算状态
    private String cart_state;
//    订单id
    private String cart_order_id;
//    购买数量
    private Integer cart_sum;
//    商品封面
    private String cart_img;
//    用户id
    private Integer u_id;
//    卖家ID
    private Integer seller_id;
//    购物车商品单价
    private Double cart_p_price;
//    uuid 随机不重复id
    private String cart_uuid;

    private Integer count;
}
