package com.webshop.webshop.controller.manage;

import com.webshop.webshop.dao.ImgMapper;
import com.webshop.webshop.pojo.Images;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Copyright (C), 2018-2020
 * FileName: UpdataProduct
 * Author:
 * Date:     2020/2/18 16:06
 * Description:更新商品
 */
@Controller
public class UpdateProduct {
    @Autowired
    private ProductServerImp productServerImp;
    @Autowired
    private ImgMapper imgMapper;
    @RequestMapping("UpdatePro")
    public String test(Product product,
                       MultipartFile file,
                       MultipartFile file1,
                       MultipartFile file2,
                       MultipartFile file3,
                       MultipartFile file4,String oldimg) throws Exception {
        // 文件名
        String newImgName = null;
        String newImgName1 = null;
        String newImgName2 = null;
        String newImgName3 = null;
        String newImgName4 = null;
//        初始化：获取老图片名
        Images images1 = imgMapper.SelImgByUid(product.getP_uuid());
        //获取项目路径
        String property = System.getProperty("user.dir");
        String s1 = property.replaceAll("\\\\", "/");
        String s2 = "/src/main/resources/static/images/";
        String path = s1 + s2;
        System.out.println("文件保存路径：" + path);
//        检测数据是否正常
        System.out.println(product+file.getName());
//        检测文件上传是否正常
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
int imgsum=0;
        if (!file.isEmpty()) {
            //获取主封面后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            newImgName = pikId + "." + fileExt;
//            保存新文件
            file.transferTo(new File(path + newImgName));
//            删除老文件
            new File(path + oldimg).delete();
        }
        if (!file1.isEmpty()) {
            imgsum++;
            //获取主封面后缀
            String fileExt1 = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            newImgName1 = pikId+"1" + "." + fileExt1;
            //            保存文件
            file1.transferTo(new File(path + newImgName1));
            //            删除老文件
            try {
                new File(path + images1.getImg1()).delete();
            } catch (Exception e) {
            }
        }
         if (!file2.isEmpty()) {imgsum++;
             //获取主封面后缀
             String fileExt2 = file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
             // 重构文件名称
             newImgName2 = pikId+"2" + "." + fileExt2;
             //            保存文件
             file2.transferTo(new File(path + newImgName2));
             //            删除老文件
             try {
                 new File(path + images1.getImg2()).delete();
             } catch (Exception e) {
             }
        }
         if (!file3.isEmpty()) {imgsum++;
             //获取主封面后缀
             String fileExt3 = file3.getOriginalFilename().substring(file3.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
             // 重构文件名称
             newImgName3 = pikId+"3" + "." + fileExt3;
             //            保存文件
             file3.transferTo(new File(path + newImgName3));
             //            删除老文件
             try {
                 new File(path + images1.getImg3()).delete();
             } catch (Exception e) {
             }
        }
         if (!file4.isEmpty()) {imgsum++;
             //获取主封面后缀
             String fileExt4 = file4.getOriginalFilename().substring(file4.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
             // 重构文件名称
             newImgName4 = pikId+"4" + "." + fileExt4;
             //            保存文件
             file4.transferTo(new File(path + newImgName4));
             //            删除老文件
             try {
                 new File(path + images1.getImg4()).delete();
             } catch (Exception e) {
             }
        }
//         开始更新图片
         Images images = new Images();
         images.setImg1(newImgName1);
         images.setImg2(newImgName2);
         images.setImg3(newImgName3);
         images.setImg4(newImgName4);
         images.setP_uuid(product.getP_uuid());
        try {
            images.setIntro(product.getIntro());
            imgsum++;
        } catch (Exception e) {
        }
        if (imgsum>0) {
            int i = imgMapper.UpdImgByUuid(images);
        }
//        开始更新商品信息
        product.setP_img(newImgName);
        int i1 = productServerImp.UpdProById(product);
        return "manage/manage";
    }
}
