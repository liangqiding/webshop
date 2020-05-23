package com.webshop.webshop.service;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.pojo.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductServer {
    PageInfo<Product> SelAllProduct(Integer pageNum,Integer pageSize,Product product);
    int UpdProById(Product product);
    int InsPro(Product product);
    int DelProById(Integer p_id);
    Product SelProductByPid(Integer p_id);

}
