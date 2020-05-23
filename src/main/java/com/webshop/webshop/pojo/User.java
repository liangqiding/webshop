package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Copyright (C), 2018-2020
 * FileName: User
 * Author:
 * Date:     2020/2/17 14:47
 * Description: 用户表
 */
@Data
@ToString
public class User {
    private Integer id;
    private String u_name;
    private String password;
    private String username;
    private Integer role_id;
    private Integer age;
    private String hobby;
    private String sex;
    private String email;
}
