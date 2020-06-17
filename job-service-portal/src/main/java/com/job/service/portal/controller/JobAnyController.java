package com.job.service.portal.controller;

import com.job.service.common.restful.CommonRes;
import com.job.service.portal.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@CrossOrigin
@RestController
@RequestMapping(value = "/job")
public class JobAnyController {

    @Autowired
    private JobService jobService;

    /**
     * 获取所有工作数量 按城市
     * city = 'all' 时查找所有
     *
     * @param city 查找的城市名
     * @return result
     */
    @GetMapping("/getJobNum")
    @ResponseBody
    @ApiOperation(value = "工作数查询", notes = "获取所有工作数量 按城市")
    public CommonRes getJobNum(@RequestParam(name = "city") String city){
        int jobNum = jobService.getJobNum(city);
        return CommonRes.create(jobNum);
    }


    /**
     * 获取指定城市各区域工作数量
     *
     * @param city 查找的城市名
     * @return result
     */
    @GetMapping("/getAreaJobNum")
    @ResponseBody
    @ApiOperation(value = "区域工作数查询", notes = "获取指定城市各区域工作数量")
    public CommonRes getAreaJobNum(@RequestParam(name = "city") String city){
        List<Map<String, Object>> areaJobNum = jobService.getAreaJobNum(city);
        return CommonRes.create(areaJobNum);
    }

    /**
     * 搜索(简单版)
     * v1简单版先只对工作的职位position, 及公司名name进行搜索
     *
     * @param key 搜索关键词
     * @return result
     */
    @GetMapping("/search")
    @ResponseBody
    @ApiOperation(value = "搜索", notes = "简单搜索")
    public CommonRes search(@RequestParam(name = "key") String key){
        // --TODO 分页处理
        List<Map<String, Object>> areaJobNum = jobService.search(key);
        return CommonRes.create(areaJobNum);
    }



    /**
     * 城市工作数分布
     *
     * @return result
     */
    @GetMapping("/getJobNumMap")
    @ResponseBody
    @ApiOperation(value = "城市工作数分布", notes = "城市工作数分布")
    public CommonRes getJobNumMap(){
        List<Map<String, Object>> areaJobNum = jobService.getJobNumMap();
        return CommonRes.create(areaJobNum);
    }


    /**
     * 擅长的技术
     *
     * @return result
     */
    @GetMapping("/getTechTag")
    @ResponseBody
    @ApiOperation(value = "擅长的技术下拉框", notes = "擅长的技术下拉框")
    public CommonRes getTechTag(){
        List<Map<String, Object>> techTag = jobService.getTechTag();
        return CommonRes.create(techTag);
    }

}
