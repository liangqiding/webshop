package com.webshop.webshop.service.imp;

import com.webshop.webshop.dao.AddressMapper;
import com.webshop.webshop.pojo.Address;
import com.webshop.webshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: AddressServiceImp
 * Author:
 * Date:     2020/2/20 15:47
 * Description:
 */
@Service
public class AddressServiceImp implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public int InsAddress(Address address) {
        return addressMapper.InsAddress(address);
    }

    @Override
    public int UpdAddressByid(Address address) {
        return addressMapper.UpdAddressByid(address);
    }

    @Override
    public int DelAddressByid(Integer id) {
        return addressMapper.DelAddressByid(id);
    }

    @Override
    public List<Address> SelAddressByuid(Integer u_id) {
        return addressMapper.SelAddressByuid(u_id);
    }

    @Override
    public Address SelAddressByuidOne(Integer u_id) {
        return addressMapper.SelAddressByuidOne(u_id);
    }

    @Override
    public int CountAddress(Integer u_id) {
        return addressMapper.CountAddress(u_id);
    }
}
