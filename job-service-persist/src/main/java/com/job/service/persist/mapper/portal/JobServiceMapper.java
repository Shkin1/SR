package com.job.service.persist.mapper.portal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/6 15:24
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Mapper
public interface JobServiceMapper {
    /**
     * getJobNum
     *
     * @param city city
     * @return
     */
    int getJobNum(@Param("city") String city);

    /**
     * getAreaJobNum
     *
     * @param city
     * @return
     */
    List<Map<String, Object>> getAreaJobNum(@Param("city") String city);

    /**
     * search
     *
     * @param key
     * @return
     */
    List<Map<String,Object>> search(@Param("key") String key);

    /**
     * 工作数分布图
     *
     * @return
     */
    List<Map<String, Object>> getJobNumMap();
}
