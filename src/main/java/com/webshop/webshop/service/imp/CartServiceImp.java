package com.webshop.webshop.service.imp;

import com.webshop.webshop.dao.CartMapper;
import com.webshop.webshop.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: CartServiceImp
 * Author:
 * Date:     2020/2/20 16:54
 * Description:
 */
@Service
public class CartServiceImp implements CartMapper {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public int InsCart(Cart cart) {
        return cartMapper.InsCart(cart);
    }

    @Override
    public List<Cart> SelCartByU_idAndState(Cart cart) {
        return cartMapper.SelCartByU_idAndState(cart);
    }

    @Override
    public int UpdCartByid(Cart cart) {
        return cartMapper.UpdCartByid(cart);
    }

    @Override
    public int UpdCartByStateAndU_idAndC_id(Cart cart) {
        return cartMapper.UpdCartByStateAndU_idAndC_id(cart);
    }

    @Override
    public List<Cart>  Sel_CartCar_All_state_uid(Cart cart) {
        return cartMapper.Sel_CartCar_All_state_uid(cart);
    }

    @Override
    public int SelCartCount(Cart cart) {
        return cartMapper.SelCartCount(cart);
    }

    @Override
    public int UpdCart_CarByid(Cart cart) {
        return cartMapper.UpdCart_CarByid(cart);
    }
//结算购物车
    @Override
    public int UpdCart_Car(Cart cart) {
        return cartMapper.UpdCart_Car(cart);
    }
}
