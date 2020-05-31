package com.sr.job.service.etl.spiders;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.job.service.common.util.AddressUtil;
import com.job.service.common.util.CommonUtil;
import com.sr.job.service.etl.schedule.JobSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/10 19:13
 * <p>Description: 爬虫启动类
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public class SpiderJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpiderJob.class);


    public static void start(String startUrl, String key, String city) {

        HashMap<String, String> addressDictMap = AddressUtil.initAddDictMap();
        if (!addressDictMap.containsKey(city)) {
            LOGGER.warn("{} 编码暂未收集", city);
            return;
        }
        String addressCode = addressDictMap.get(city);
        String encodeKey;
        try {
            encodeKey = CommonUtil.encodeParam(key);
        } catch (UnsupportedEncodingException e) {
            LOGGER.warn("{} 编码转码失败", key);
            return;
        }
        String spiderStartUrl = startUrl.replace("addressCode", addressCode).replace("key", encodeKey);
        LOGGER.info("搜索关键词:{}, 城市:{}, 城市码:{} ", key, city, addressCode);
        LOGGER.info("start url:{}", spiderStartUrl);
        HttpGetRequest nStartUrl = new HttpGetRequest(spiderStartUrl);
        nStartUrl.addParameter("key", key);
        nStartUrl.addParameter("city", city);
        nStartUrl.addParameter("addressCode", addressCode);
        nStartUrl.setCharset("GBK");
        JobSchedule.isOpenJobSchedule = true;
        LOGGER.info(">>>>>>>>> open JobSchedule <<<<<<<<<<");
        GeccoEngine.create().classpath("com.sr.demo.etl.spiders").start(nStartUrl).thread(80)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(100)
                .run();
        LOGGER.info("完成,{},{},爬虫任务",city,key);
        JobSchedule.isOpenJobSchedule = false;
        LOGGER.info(">>>>>>>>> close JobSchedule <<<<<<<<<<");
    }


    public static void main(String[] args) {
        String testUrl = "https://search.51job.com/list/addressCode,000000,0000,00,9,99,key,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        start(testUrl, "推荐系统", "杭州");
    }
}
