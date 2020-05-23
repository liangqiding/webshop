package com.webshop.webshop.service;

import com.webshop.webshop.pojo.Cart;

import java.util.List;

public interface CartService {
    int InsCart(Cart cart);
    List<Cart> SelCartByU_idAndState(Cart cart);
    int UpdCartByid(Cart cart);
    int UpdCartByStateAndU_idAndC_id(Cart cart);
    List<Cart>  Sel_CartCar_All_state_uid(Cart cart);
    //   统计购物车总数
    int SelCartCount(Cart cart);
    int UpdCart_CarByid(Cart cart);
    int UpdCart_Car(Cart cart);
}
