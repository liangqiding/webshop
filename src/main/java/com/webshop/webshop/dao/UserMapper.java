package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * Copyright (C), 2018-2020
 * FileName: UserMapper
 * Author:
 * Date:     2020/2/17 14:49
 * Description:
 */
@Mapper
public interface UserMapper {
    User SelectUserByUsername(String username);
    int InsterUser(User user);
// int SelectUserByUsername(String username);
//    更新个人信息
    int UpdUserByUsername(User user);
}
