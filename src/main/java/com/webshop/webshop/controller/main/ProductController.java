package com.webshop.webshop.controller.main;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Product
 * Author:
 * Date:     2020/2/18 9:25
 * Description:生成购物清单
 */
@Controller
public class ProductController {
    @Autowired
    private ProductServerImp productServerImp;

    //    获取页面商品数据---新款商品
    @RequestMapping("/SelProduct")
    @ResponseBody
    public List<Product> test(HttpSession session) {
        Product product = new Product();
        int pageNum=1;
        try {
            String p_name = (String) session.getAttribute("p_name");
            if (p_name != null)
                product.setP_name(p_name);
        } catch (Exception e) {
        }
        try {
            Integer p_classid = (Integer) session.getAttribute("p_classid");
            if (p_classid != null&&p_classid!=0) {
                product.setP_classid(p_classid);
            }
        } catch (Exception e) {
        }
        try {
            int pageNums = (Integer) session.getAttribute("pageNum");
           pageNum=pageNums;
        } catch (Exception e) {
        }
        PageInfo<Product> productPageInfo = productServerImp.SelAllProduct(pageNum, 4, product);
        List<Product> list = productPageInfo.getList();
        System.out.println(list);
        return list;
    }
}
