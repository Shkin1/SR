package com.sr.demo.mapper;

import com.sr.demo.model.CategoryModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryModel record);

    int insertSelective(CategoryModel record);

    CategoryModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryModel record);

    int updateByPrimaryKey(CategoryModel record);
}