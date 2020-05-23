package com.webshop.webshop;

import com.github.pagehelper.PageInfo;
import com.webshop.webshop.dao.CartMapper;
import com.webshop.webshop.dao.LoveMapper;
import com.webshop.webshop.dao.OrderMapper;
import com.webshop.webshop.dao.UserMapper;
import com.webshop.webshop.pojo.*;
import com.webshop.webshop.service.imp.ProductServerImp;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebshopApplicationTests {
    @Autowired
    ProductServerImp productServerImp;
    @Autowired
    CartMapper cartMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    LoveMapper loveMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
//        加密测试
        SimpleHash hash = new SimpleHash("MD5", "1", "xxx", 1024);
        System.out.println(hash.toString());
    }

    @Test
    public void test() {
        PageInfo<Product> productPageInfo = productServerImp.SelAllProduct(1, 4, null);
        System.out.println(productPageInfo.getList());
    }

    @Test
    public void test2() {
        Product product1 = new Product();
        product1.setDate("666");
        product1.setP_id(1);
        int product = productServerImp.UpdProById(product1);
        int i = productServerImp.InsPro(product1);
        System.out.println(product + i);
    }

    @Test
    public void test4() {
        Cart cart = new Cart();
        cart.setCart_date("aaaaaaaaaaaaaaaaa");
        int i = cartMapper.InsCart(cart);
        System.out.println(i);
    }
    @Test
    public void test5() {
        Order order = new Order();
        order.setAddress("6666");
        int i = orderMapper.InsOrder(order);
        System.out.println(i);
    }
    @Test
    public void test6() {
        Cart cart = new Cart();
        cart.setCart_state("ceshi");
        cart.setCart_id(113);
        cart.setU_id(1);
        int i = cartMapper.UpdCartByStateAndU_idAndC_id(cart);
    }
    @Test
    void  o(){
        Love love = new Love();
        love.setU_id(1);
        List<Love> loves = loveMapper.SelLoveByUidOrId(love);
    }
    @Test
    void u(){
        User user = new User();
        user.setUsername("1");
        user.setEmail("1111");
        int i = userMapper.UpdUserByUsername(user);
        System.out.println(i);
    }
    @Test
    public void test22() {

            Integer [][] arr=new Integer[20][20];
        System.out.println(arr.length+arr[0].length);
        }

}
