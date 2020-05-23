package com.webshop.webshop.controller.manage;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.dao.ImgMapper;
import com.webshop.webshop.pojo.Images;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: ManageController
 * Author:
 * Date:     2020/2/18 13:02
 * Description: 后台管理
 */
@Controller
public class ManageController {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private ImgMapper imgMapper;

    //    跳转后台
    @RequestMapping("/manage")
    public String test() {
        return "manage/manage";
    }

    //返回后台商品数据
//    注意 这里根据不同的卖家，返回不同的数据,Admin为超级管理员，可查看所有信息
    @RequestMapping("/SelManPro")
    @ResponseBody
    public List<Product> SelectManageProduct() {
        PageInfo<Product> productPageInfo = null;
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//        标记
        User user = new User();
        Product product = new Product();
        user.setId(1);
        if (user.getRole_id() != null && user.getRole_id() == 1) {
            productPageInfo = productServerImp.SelAllProduct(1, 100, null);
        } else {
            product.setP_userid(user.getId());
            productPageInfo = productServerImp.SelAllProduct(1, 100, product);
        }
        System.out.println(productPageInfo.getList());
        return productPageInfo.getList();
    }

    //    返回商品详细信息
//    /SelImg
    @RequestMapping("/SelImg")
    @ResponseBody
    public Images SelManPro(String uuid) {
        Images images = imgMapper.SelImgByUid(uuid);
        System.out.println(images);
        return images;
    }
}
