package com.job.service.portal.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/6 15:22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface JobService {
    int getJobNum(String city);

    List<Map<String, Object>> getAreaJobNum(@Param("city") String city);

    List<Map<String,Object>> search(String key);

    /**
     * 工作数分布图
     *
     * @return
     */
    List<Map<String, Object>> getJobNumMap();
}
