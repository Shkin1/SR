package com.job.service.portal.service.impl;

import com.job.service.persist.mapper.portal.JobServiceMapper;
import com.job.service.portal.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/6 15:23
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Service
public class JobServiceImpl implements JobService {
    @Resource
    private JobServiceMapper jobServiceMapper;

    @Override
    public int getJobNum(String city) {
        return jobServiceMapper.getJobNum(city);
    }

    @Override
    public List<Map<String, Object>> getAreaJobNum(String city) {
        return jobServiceMapper.getAreaJobNum(city);
    }
}
