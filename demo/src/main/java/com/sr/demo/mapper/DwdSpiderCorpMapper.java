package com.sr.demo.mapper;

import com.sr.demo.model.DwdSpiderCorp;
import com.sr.demo.model.DwdSpiderJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DwdSpiderCorpMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(DwdSpiderCorp record);

    int insertSelective(DwdSpiderCorp record);

    DwdSpiderCorp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(DwdSpiderCorp record);

    int updateByPrimaryKeyWithBLOBs(DwdSpiderCorp record);

    int updateByPrimaryKey(DwdSpiderCorp record);

    /**
     * 批量插入.
     * @param cropList 数据
     * @return 插入条目数
     */
    int insertBatch(@Param("cropList") List<DwdSpiderCorp> cropList);
}