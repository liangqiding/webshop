package com.webshop.webshop.controller.manage;

import com.webshop.webshop.dao.ImgMapper;
import com.webshop.webshop.pojo.Images;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Copyright (C), 2018-2020
 * FileName: InsertProduct
 * Author:
 * Date:     2020/2/19 15:12
 * Description: 添加商品
 */
@Controller
public class InsertProduct {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private ImgMapper imgMapper;

    //    添加商品
    @RequestMapping("/AddPro")
    public String AddPro(HttpSession session, Product product, MultipartFile file
            , MultipartFile file1
            , MultipartFile file2
            , MultipartFile file3
            , MultipartFile file4) throws Exception {
        // 如果文件不为空，写入上传路径
        String newImgName = null;
        String newImgName1 = null;
        String newImgName2 = null;
        String newImgName3 = null;
        String newImgName4 = null;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int p_userid = 0;
        try {
            System.out.println(user);
            p_userid = user.getId();
        } catch (Exception e) {
            System.out.println("请先登录");
            return "login/index";
        }
        //获取项目路径
        String property = System.getProperty("user.dir");
        String s1 = property.replaceAll("\\\\", "/");
        String s2 = "/src/main/resources/static/images/";
        String path = s1 + s2;
        System.out.println("文件保存路径：" + path);
        // 重构文件名称
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        try {
            if (!file.isEmpty()) {
                //获取主封面后缀
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                newImgName = pikId + "1" + "." + fileExt;
                // 将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + newImgName));
            }
        } catch (IOException e) {
            System.out.println("上传失败");
        }
         try {
            if (!file1.isEmpty()) {
                //获取主封面后缀
                String fileExt1 = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                newImgName1 = pikId +"1"+ "." + fileExt1;
                // 将上传文件保存到一个目标文件当中
                file1.transferTo(new File(path + newImgName1));
            }
        } catch (IOException e) {
            System.out.println("图1上传失败");
        }
        try {
            if (!file2.isEmpty()) {
                //获取主封面后缀
                String fileExt2 = file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                newImgName2 = pikId +"2"+ "." + fileExt2;
                // 将上传文件保存到一个目标文件当中
                file2.transferTo(new File(path + newImgName2));
            }
        } catch (IOException e) {
            System.out.println("图2上传失败");
        }
        try {
            if (!file3.isEmpty()) {
                //获取主封面后缀
                String fileExt3 = file3.getOriginalFilename().substring(file3.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                newImgName3 = pikId +"3"+ "." + fileExt3;
                // 将上传文件保存到一个目标文件当中
                file3.transferTo(new File(path + newImgName3));
            }
        } catch (IOException e) {
            System.out.println("图3上传失败");
        }
        try {
            if (!file4.isEmpty()) {
                //获取主封面后缀
                String fileExt4 = file4.getOriginalFilename().substring(file4.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                newImgName4 = pikId +"4"+ "." + fileExt4;
                // 将上传文件保存到一个目标文件当中
                file4.transferTo(new File(path + newImgName4));
            }
        } catch (IOException e) {
            System.out.println("图4上传失败");
        }

//    设置创建时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date.getTime());
//        绑定卖家id
        product.setP_userid(p_userid);
//绑定商品创建时间
        product.setDate(time);
//设置商品id
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        product.setP_imgid(uuid);
        product.setP_uuid(uuid);
//        设置商品封面
        product.setP_img(newImgName);
//    操作数据库
        int i = productServerImp.InsPro(product);

//插入介绍图
        Images images = new Images();
        images.setP_uuid(uuid);
        images.setImg1(newImgName1);
        images.setImg2(newImgName2);
        images.setImg3(newImgName3);
        images.setImg4(newImgName4);
        images.setImg5(null);
       images.setIntro(product.getIntro());
        int i1 = imgMapper.InsterImg(images);
        System.out.println("插入数据成功！"+i+i1);
        return "manage/manage";
    }
}
