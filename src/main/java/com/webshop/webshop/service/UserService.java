package com.webshop.webshop.service;

import com.webshop.webshop.pojo.User;

public interface UserService {
    User SelectUserByUsername(String username);
    int InsterUser(User user);
    int UpdUserByUsername(User user);
}
