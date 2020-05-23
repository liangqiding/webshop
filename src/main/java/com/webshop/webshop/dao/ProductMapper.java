package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProductMapper {
//    查询所有商品
List<Product> SelAllProduct(Product product);
//更新
    int UpdProById(Product product);
//    增加
    int InsPro(Product product);
//    删除
    int DelProById(Integer p_id);
//    根据ID查询
    Product SelProductByPid(@Param(value = "p_id") Integer p_id);
}
