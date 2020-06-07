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
     *
     * @param city city
     * @return
     */
    int getJobNum(@Param("city") String city);

    /**
     *
     * @param city
     * @return
     */
    List<Map<String, Object>> getAreaJobNum(@Param("city") String city);
}
