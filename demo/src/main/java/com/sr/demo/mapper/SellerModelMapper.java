package com.sr.demo.mapper;

import com.sr.demo.model.SellerModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SellerModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SellerModel record);

    int insertSelective(SellerModel record);

    SellerModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellerModel record);

    int updateByPrimaryKey(SellerModel record);
    List<SellerModel> selectAll();
    Integer countAllSeller();
}