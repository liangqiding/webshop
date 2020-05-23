package com.webshop.webshop.controller.main.personal;

import com.webshop.webshop.pojo.Love;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.pojo.User;
import com.webshop.webshop.service.imp.LoveServiceImp;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: LoveController
 * Author:
 * Date:     2020/2/22 16:40
 * Description: 我的收藏
 */
@Controller
public class LoveController {
    @Autowired
    private LoveServiceImp loveServiceImp;

    //跳转收藏界面
    @RequestMapping("/love")
    public String CheckOut2() {
        return "main/personal/love";
    }

    //        获取收藏信息
    @RequestMapping("/SelLoveByU_id")
    @ResponseBody
    public List<Love> SelLoveByU_id() {
        Integer userU_id = getUserU_id();
        if (userU_id <= 0) {
            return null;
        }
        Love love = new Love();
        love.setU_id(userU_id);
        List<Love> loves = loveServiceImp.SelLoveByUidOrId(love);
        return loves;
    }

    //       添加收藏
    @RequestMapping("/AddLove")
    @ResponseBody
    public String AddLove(Love love) {
        Integer userU_id = getUserU_id();
        if (userU_id <= 0) {
            return "请先登录";
        }
        love.setU_id(userU_id);
        int i1 = loveServiceImp.SelLoveCount(love);
        if (i1>=1){
            return "您已添加过了";
        }
        int i = loveServiceImp.InsLove(love);
        if (i > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    //删除 收藏
    @RequestMapping("/DelLoveById")
    @ResponseBody
    public String DelLoveById(Integer p_id) {
        Integer userU_id = getUserU_id();
        if (userU_id <= 0) {
            return "请先登录";
        }
        Love love = new Love();
        love.setU_id(userU_id);
        love.setP_id(p_id);
        int i = loveServiceImp.DelLoveById(love);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }
    //统计 收藏数
    @RequestMapping("/SelLoveCount")
    @ResponseBody
    public Integer SelLoveCount() {
        Integer userU_id = getUserU_id();
        if (userU_id <= 0) {
            return 0;
        }
        Love love = new Love();
        love.setU_id(userU_id);
        int i = loveServiceImp.SelLoveCount(love);
        return i;
    }
    //查询出收藏商品的 具体信息
    @RequestMapping("/SelLovePro")
    @ResponseBody
    public List<Product> SelLovePro() {
        Integer userU_id = getUserU_id();
        if (userU_id <= 0) {
            return null;
        }
        List<Product> products = loveServiceImp.SelLovePro(userU_id);
        return  products;
    }
    //    封装获取u_id方法
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
