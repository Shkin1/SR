package com.job.service.portal.controller;

import com.job.service.common.config.EtlProps;
import com.job.service.common.restful.CommonRes;
import com.sr.job.service.etl.spiders.SpiderJob;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/11 12:32
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@RestController
@RequestMapping(value = "/spider")
public class JobSpiderController {
    @Value("${demo.spider.start.url}")
    private String startUrl;

    @GetMapping("/51job")
    @ResponseBody
    @ApiOperation(value = "爬虫", notes = "爬虫")
    public CommonRes recommend(@RequestParam(name = "city") String city){
        String[] jobSearchKeys = EtlProps.JOB_SEARCH_KEY.split(",");
        for (String jobSearchKey : jobSearchKeys) {
            SpiderJob.start(startUrl,jobSearchKey,city);
        }
        return CommonRes.create("爬取完成");
    }
}
