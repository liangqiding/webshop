package com.webshop.webshop.controller.main.Order;

import com.webshop.webshop.dao.ImgMapper;
import com.webshop.webshop.pojo.Images;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2018-2020
 * FileName: BuyController
 * Author:
 * Date:     2020/2/18 14:15
 * Description: 购买功能
 */
@Controller
public class BuyController {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private ImgMapper imgMapper;

    //    跳转商品详情
    @RequestMapping("/buy")
    public String Buy(HttpSession session, Integer p_id, String p_uuid, HttpServletRequest request) {
        session.setAttribute("p_id",p_id);
        session.setAttribute("p_uuid",p_uuid);
        Images images = imgMapper.SelImgByUid(p_uuid);
        request.setAttribute("imgs",images);
        System.out.println("images:"+images);
        return "main/product";
    }

    //        获取商品信息
    @RequestMapping("/SelProductOne")
    @ResponseBody
    public Product SelProductOne(HttpSession session,Integer p_id) {
        Integer p_id1 = (Integer) session.getAttribute("p_id");
        Product product = productServerImp.SelProductByPid(p_id1);
        System.out.println(product);
        return product;
    }
    //        获取商品详细信息
    @RequestMapping("/SelProductImg")
    @ResponseBody
    public Images SelProductImg(HttpSession session,Integer p_id) {
        String p_uuid = (String) session.getAttribute("p_uuid");
        Images images = imgMapper.SelImgByUid(p_uuid);
        System.out.println("images:"+images);
        return images;
    }

}
