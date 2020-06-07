package com.job.service.portal.controller;

import com.job.service.common.restful.CommonRes;
import com.job.service.portal.service.JobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/6 15:02
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Api(description = "job接口")
@RestController
@RequestMapping(value = "/job")
public class JobAnyController {

    @Autowired
    private JobService jobService;

    // 1. 获取所有工作数量 按城市
    @GetMapping("/getJobNum")
    @ResponseBody
    public CommonRes getJobNum(@RequestParam(name = "city") String city){
        int jobNum = jobService.getJobNum(city);
        return CommonRes.create(jobNum);
    }



    // 1. 获取所有工作数量 按城市
    @GetMapping("/getAreaJobNum")
    @ResponseBody
    public CommonRes getAreaJobNum(@RequestParam(name = "city") String city){
        List<Map<String, Object>> areaJobNum = jobService.getAreaJobNum(city);
        return CommonRes.create(areaJobNum);
    }
}
