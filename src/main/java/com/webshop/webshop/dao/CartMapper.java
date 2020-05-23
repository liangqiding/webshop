package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    int InsCart(Cart cart);
    List<Cart> SelCartByU_idAndState(Cart cart);
    int UpdCartByid(Cart cart);
    int UpdCartByStateAndU_idAndC_id(Cart cart);
//    查询购物车
   List<Cart>  Sel_CartCar_All_state_uid(Cart cart);
//   统计购物车总数
    int SelCartCount(Cart cart);
//    购物车更新
    int UpdCart_CarByid(Cart cart);
//    结算购物车
    int UpdCart_Car(Cart cart);

}
