package com.job.service.persist.mapper.etl;

import com.job.service.persist.model.DwdSpiderJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DwdSpiderJobMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(DwdSpiderJob record);

    int insertSelective(DwdSpiderJob record);

    DwdSpiderJob selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(DwdSpiderJob record);

    int updateByPrimaryKeyWithBLOBs(DwdSpiderJob record);

    int updateByPrimaryKey(DwdSpiderJob record);

    /**
     * 批量插入.
     * @param jobList 数据
     * @return 插入条目数
     */
    int insertBatch(@Param("jobList") List<DwdSpiderJob> jobList);
}