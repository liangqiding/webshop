package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Copyright (C), 2018-2020
 * FileName: Card
 * Author:
 * Date:     2020/2/20 15:08
 * Description: 个人信息
 */
@Data
@ToString
public class Card {
    private Integer id;
    private  Integer age;
    private String idcard;
    private String name;
    private String address;
    private String email;
    private String sex;
    private  String phone;
    private Integer card_id;
    private String card_date;
    private String usercode;
    private String credit;
    private Integer sum;
    private Integer u_id;
    private String date;
}
