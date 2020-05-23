package com.webshop.webshop.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2018-2020
 * FileName: SuccessController
 * Author:
 * Date:     2020/2/21 15:44
 * Description:
 */
@Controller
public class SuccessController {
    //    交易完成
    @RequestMapping("/success")
    public String CheckOut() {
        return "main/success";
    }
    //支付成功
    @RequestMapping("/successed")
    public String CheckOut2() {
        return "main/success";
    }
}
