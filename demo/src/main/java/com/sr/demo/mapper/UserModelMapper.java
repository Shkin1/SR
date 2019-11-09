package com.sr.demo.mapper;

import com.sr.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}