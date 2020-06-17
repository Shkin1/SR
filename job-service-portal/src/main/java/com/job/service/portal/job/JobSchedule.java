package com.job.service.portal.job;

import com.job.service.persist.mapper.etl.DwdSpiderCorpMapper;
import com.job.service.persist.mapper.etl.DwdSpiderJobMapper;
import com.job.service.persist.model.DwdSpiderCorp;
import com.job.service.persist.model.DwdSpiderJob;
import com.sr.job.service.etl.spiders.JobResultPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/16 18:08
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Component
public class JobSchedule {

    private final static Logger LOGGER = LoggerFactory.getLogger(JobSchedule.class);
    public static Boolean isOpenJobSchedule = true;

    @Resource
    private DwdSpiderJobMapper dwdSpiderJobMapper;

    @Resource
    private DwdSpiderCorpMapper dwdSpiderCorpMapper;

    @Scheduled(fixedRate = 30000)
    public void writeDateToMysql(){
        ArrayList<DwdSpiderJob> jobData = JobResultPipeline.aListJob;
        if (isOpenJobSchedule && jobData.size()>0){
            long start = System.currentTimeMillis();
            int i = dwdSpiderJobMapper.insertBatch(jobData);
            long end = System.currentTimeMillis();
            LOGGER.info("insert {} jobData, consume {} ms, insertBatch success {}",jobData.size(),end-start,i);
            jobData.clear();
        }
        ArrayList<DwdSpiderCorp> corpData = JobResultPipeline.aListCorp;
        if (isOpenJobSchedule && corpData.size()>0){
            long start = System.currentTimeMillis();
            int i = dwdSpiderCorpMapper.insertBatch(corpData);
            long end = System.currentTimeMillis();
            LOGGER.info("insert {} corpData, consume {} ms, insertBatch success {}",corpData.size(),end-start,i);
            corpData.clear();
        }
    }


}
