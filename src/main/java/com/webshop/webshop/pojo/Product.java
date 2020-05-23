package com.webshop.webshop.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Copyright (C); 2018-2020
 * FileName: Product
 * Author:
 * Date:     2020/2/18 9:30
 * Description:  商品表
 */
@Data
@ToString
public class Product {
    private Integer p_id;
    private String p_name;
    private Double p_price;
    private Integer p_sum;
    private Integer p_keep;
    private Integer p_userid;
    private String p_img;
    private String p_imgid;
    private String p_status;
    private Integer p_classid;
    private String classname;
    private String intro;
    private String date;
    private String p_uuid;

}
