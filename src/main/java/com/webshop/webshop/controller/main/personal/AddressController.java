package com.webshop.webshop.controller.main.personal;

import com.webshop.webshop.pojo.Address;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.AddressServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: AddressController
 * Author:
 * Date:     2020/2/20 15:32
 * Description: 地址
 */
@Controller
public class AddressController {
    @Autowired
    private AddressServiceImp addressServiceImp;

    @RequestMapping("/address")
    public String address() {
        return "main/personal/address";
    }

    //        获取地址信息
    @RequestMapping("/SelAddress")
    @ResponseBody
    public Address SelAddress() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Address addresses = null;
        try {
            addresses = addressServiceImp.SelAddressByuidOne(user.getId());
            System.out.println(addresses);
        } catch (Exception e) {
            System.out.println("user为null");
        }
        return addresses;
    }

    //        保存地址信息
    @RequestMapping("/SaveAddress")
    @ResponseBody
    public String SaveAddress(Address address) {
        Integer userU_id = getUserU_id();
        if (userU_id<=0){
            return "保存失败";
        }
        int i=0;
        if (address.getId()!=null){
             i = addressServiceImp.UpdAddressByid(address);
        }else {
            address.setU_id(userU_id);
//            判断用户是否已存在地址
            int i1 = addressServiceImp.CountAddress(userU_id);
//            不存在则创建
            if (i1==0)
            i = addressServiceImp.InsAddress(address);
        }
        if (i > 0) {
            return "保存成功";
        } else
            return "保存失败";
    }


    //    //    封装获取u_id方法
    private Integer getUserU_id() {
        Integer u_id = 0;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            u_id = user.getId();
        } catch (Exception e) {
            return 0;
        }
        return u_id;
    }
}
