package com.webshop.webshop.service;

import com.webshop.webshop.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {
    int InsAddress(Address address);
    int UpdAddressByid(Address address);
    int DelAddressByid(Integer id);
    List<Address> SelAddressByuid(@Param("u_id") Integer u_id);
    Address SelAddressByuidOne(@Param("u_id") Integer u_id);
    int CountAddress(@Param("u_id") Integer u_id);
}
