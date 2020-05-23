package com.webshop.webshop.controller.manage;

import com.webshop.webshop.dao.ImgMapper;
import com.webshop.webshop.pojo.Images;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * Copyright (C), 2018-2020
 * FileName: DelProduct
 * Author:
 * Date:     2020/2/19 16:27
 * Description:
 */
@Controller
public class DelProduct {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private ImgMapper imgMapper;
//    删除商品
    @RequestMapping("/delpro")
    @ResponseBody
    public String delpro(Integer p_id) {
        //获取项目路径
        String property = System.getProperty("user.dir");
        String s1 = property.replaceAll("\\\\", "/");
        String s2 = "/src/main/resources/static/images/";
        String path = s1 + s2;
//        查询商品及其介绍图片id
        Product product = productServerImp.SelProductByPid(p_id);
//        获取介绍图片uuid
        Images images = imgMapper.SelImgByUid(product.getP_imgid());
        System.out.println(path);//输出测试一下文件路径是否正确
//        开始删除文件
        int x=0;
        int j=0;
        try {
           if(new File(path + product.getP_img()).delete())
               x++;
        } catch (Exception e) {
            System.out.println("封面图片不存在");
        }
        try {
            if(new File(path + images.getImg1()).delete())
            j++;
        } catch (Exception e) {
            System.out.println("图片1不存在");
        }
        try {
            if(new File(path + images.getImg2()).delete())
            j++;
        } catch (Exception e) {
            System.out.println("图片2不存在");
        }
        try {
            if(new File(path + images.getImg3()).delete())
            j++;
        } catch (Exception e) {
            System.out.println("图片3不存在");
        }
        try {
            if(new File(path + images.getImg4()).delete())
            j++;
        } catch (Exception e) {
            System.out.println("图片4不存在");
        }
//        if (file.exists()) {//文件是否存在
//            file.delete();//存在就删了，返回1
//        }
        int i = productServerImp.DelProById(p_id);
        int del=imgMapper.DelImgByUuid(product.getP_imgid());
        return "删除了"+i+"个商品，本地文件删除情况：成功删除了"+x+"个封面文件，"+j+"个介绍图片";
    }
}
