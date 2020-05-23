package com.webshop.webshop.service;

import com.webshop.webshop.pojo.Love;
import com.webshop.webshop.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoveService {
    List<Love> SelLoveByUidOrId(Love love);
    int InsLove(Love love);
    int DelLoveById(Love love);
    int SelLoveCount(Love love);
    List<Product> SelLovePro(@Param("u_id")Integer u_id);
}
