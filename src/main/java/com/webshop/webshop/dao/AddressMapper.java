package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper {
//    地址管理
    int InsAddress(Address address);
    int UpdAddressByid(Address address);
    int DelAddressByid(@Param("id") Integer id);
    List<Address> SelAddressByuid(@Param("u_id") Integer u_id);
    Address SelAddressByuidOne(@Param("u_id") Integer u_id);
    int CountAddress(@Param("u_id") Integer u_id);
}
