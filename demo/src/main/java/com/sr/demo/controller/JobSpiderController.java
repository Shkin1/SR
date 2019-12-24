package com.sr.demo.controller;

import com.sr.demo.common.CommonRes;
import com.sr.demo.config.EtlProps;
import com.sr.demo.etl.spiders.SpiderJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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

    @RequestMapping("/51job")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name = "city") String city){
        String[] jobSearchKeys = EtlProps.JOB_SEARCH_KEY.split(",");
        for (String jobSearchKey : jobSearchKeys) {
            SpiderJob.start(startUrl,jobSearchKey,city);
        }
        return CommonRes.create("爬取完成");
    }
}
