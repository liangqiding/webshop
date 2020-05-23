package com.webshop.webshop.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2018-2020
 * FileName: OrderManageController
 * Author:
 * Date:     2020/2/24 10:55
 * Description:
 */
@Controller
public class OrderManageController {
    //    跳转订单管理
    @RequestMapping("/ordermanage")
    public String CheckOut() {
        return "manage/Order";
    }
//    更新订单

}
