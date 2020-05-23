package com.webshop.webshop.dao;

import com.webshop.webshop.pojo.Images;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgMapper {
//    插入介绍图
    int InsterImg(Images images);
//    根据uuid查询商品信息
    Images SelImgByUid(String uuid);
//    删除图片
    int DelImgByUuid(String p_uuid);
//    更新图片
    int UpdImgByUuid(Images images);
}
