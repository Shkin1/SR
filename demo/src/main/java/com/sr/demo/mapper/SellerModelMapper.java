package com.sr.demo.mapper;

import com.sr.demo.model.SellerModel;

public interface SellerModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerModel record);

    int insertSelective(SellerModel record);

    SellerModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellerModel record);

    int updateByPrimaryKey(SellerModel record);
}