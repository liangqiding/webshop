package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Copyright (C), 2018-2020
 * FileName: Address
 * Author:
 * Date:     2020/2/20 15:37
 * Description:
 */
@Data
@ToString
public class Address {
    private Integer id;
    private String name;
    private String address;
    private  String phone;
    private Integer u_id;
}
