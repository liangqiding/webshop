package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Love;
import com.webshop.webshop.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoveMapper {
//    查询收藏列表
    List<Love> SelLoveByUidOrId(Love love);
//    新增收藏的商品
    int InsLove(Love love);
//    删除收藏
    int DelLoveById(Love love);
//    统计用户收藏数量
    int SelLoveCount(Love love);
//    2表左连接查询 查询出收藏的具体商品
    List<Product> SelLovePro(@Param("u_id")Integer u_id);
}
