package com.webshop.webshop.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webshop.webshop.dao.ProductMapper;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.ProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: ProductServerImp
 * Author:
 * Date:     2020/2/18 9:33
 * Description: 商品
 */
@Service
public class ProductServerImp implements ProductServer {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo<Product> SelAllProduct(Integer pageNum,Integer pageSize,Product product) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productMapper.SelAllProduct(product);
        PageInfo<Product> PageInfo = new PageInfo<>(products);
        return PageInfo;
    }

    @Override
    public int UpdProById(Product product) {
        return productMapper.UpdProById(product);
    }

    @Override
    public int InsPro(Product product) {
        return productMapper.InsPro(product);
    }

    @Override
    public int DelProById(Integer p_id) {
        return productMapper.DelProById(p_id);
    }

    @Override
    public Product SelProductByPid(Integer p_id) {
        return productMapper.SelProductByPid(p_id);
    }
}
