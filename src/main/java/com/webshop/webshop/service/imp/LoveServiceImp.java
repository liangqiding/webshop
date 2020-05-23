package com.webshop.webshop.service.imp;

import com.webshop.webshop.dao.LoveMapper;
import com.webshop.webshop.pojo.Love;
import com.webshop.webshop.pojo.Product;
import com.webshop.webshop.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: LoveServiceImp
 * Author:
 * Date:     2020/2/23 8:04
 * Description:
 */
@Service
public class LoveServiceImp implements LoveService {
    @Autowired
    private LoveMapper loveMapper;
    @Override
    public List<Love> SelLoveByUidOrId(Love love) {
        return loveMapper.SelLoveByUidOrId(love);
    }

    @Override
    public int InsLove(Love love) {
        return loveMapper.InsLove(love);
    }

    @Override
    public int DelLoveById(Love love) {
        return loveMapper.DelLoveById(love);
    }

    @Override
    public int SelLoveCount(Love love) {
        return loveMapper.SelLoveCount(love);
    }

    @Override
    public List<Product> SelLovePro(Integer u_id) {
        return loveMapper.SelLovePro(u_id);
    }
}
