package com.sr.demo.etl.spiders;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.sr.demo.common.CommonUtil;
import com.sr.demo.common.JobEtlUtil;
import com.sr.demo.config.EtlProps;
import com.sr.demo.model.DwdSpiderCorp;
import com.sr.demo.model.DwdSpiderJob;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/10 19:05
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Component
@PipelineName(value="jobResultPipeline")
public class JobResultPipeline implements Pipeline<JobDetailBean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobResultPipeline.class);
    private static int i = 0;
    /**
     * 缓存结果
     */
    public static ArrayList<DwdSpiderJob> aListJob = new ArrayList<>();
    public static ArrayList<DwdSpiderCorp> aListCorp = new ArrayList<>();

    @Override
    public void process(JobDetailBean bean) {
        i = i + 1;
        LOGGER.info("已爬取数据:{}",i);
        DwdSpiderJob dwdSpiderJob = new DwdSpiderJob();
        DwdSpiderCorp dwdSpiderCorp = new DwdSpiderCorp();

        HttpRequest request = bean.getRequest();
        String searchKey = request.getParameter("key");
        String address = request.getParameter("address");
        String addressCode = request.getParameter("addressCode");
        String city = request.getParameter("city");
        String publishTime = request.getParameter("publishTime");

        List<String> fuliTag = bean.getFuliTag();
        List<String> typeDesc = bean.getTypeDesc();
        List<String> jobDesc = bean.getJobDesc();
        List<String> companyTrade = bean.getCompanyTrade();
        String salary = bean.getSalary();
        String typeDescStr = StringUtils.join(typeDesc.toArray(), ",");
        String jobDescStr = StringUtils.join(jobDesc.toArray(), ",");

        // 清洗学历字段
        Integer eduLevel = JobEtlUtil.getEduLevel(typeDescStr);
        // 清洗经验字段
        Integer experience = JobEtlUtil.getExperience(typeDescStr);
        if (eduLevel == 0){
            experience = JobEtlUtil.getExperience(jobDescStr);
        }
        // 清洗薪水类型字段
        String salayType = JobEtlUtil.getSalayType(salary);
        // 清洗薪水起止字段
        JobEtlUtil.getSalayRange(salary,dwdSpiderJob);
        // 清洗招聘人数字段
        String positionPeoples = JobEtlUtil.getPositionPeoples(typeDescStr);


        String jobName = bean.getTitle();
        String corpName = bean.getCompany();
        String uuid = null;
        try {
            uuid = CommonUtil.encodeByMd5(request.getUrl() + publishTime);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (uuid == null){
            LOGGER.info("uuid is null, url:{}, publishTime{}",request.getUrl(),publishTime);
        }else {
            // dwdSpiderCorp表数据
            dwdSpiderCorp.setUuid(uuid);
            dwdSpiderCorp.setName(bean.getCompany());
            dwdSpiderCorp.setType(bean.getCompanyType());
            dwdSpiderCorp.setPeoples(bean.getCompanyPeople());
            dwdSpiderCorp.setTradeTag(StringUtils.join(companyTrade,","));
            dwdSpiderCorp.setUrl(bean.getCompanyUrl());
            dwdSpiderCorp.setInfo(bean.getCompanyDesc());
            // dwdSpiderJob表数据
            dwdSpiderJob.setUuid(uuid);
            dwdSpiderJob.setSearchKey(CommonUtil.decodeParam(searchKey));
            dwdSpiderJob.setCity(city);
            dwdSpiderJob.setCityDetail(address);
            dwdSpiderJob.setCityCode(addressCode);
            dwdSpiderJob.setPosition(jobName);
            dwdSpiderJob.setPositionPeoples(positionPeoples);
            dwdSpiderJob.setSummaryTag(typeDescStr);
            dwdSpiderJob.setSalary(salary);
            dwdSpiderJob.setSalaryType(salayType);
            dwdSpiderJob.setWelfareTag(StringUtils.join(fuliTag.toArray(),","));
            dwdSpiderJob.setPositionDesc(jobDescStr);
            dwdSpiderJob.setPublishDate(publishTime);
            dwdSpiderJob.setUrl(request.getUrl());
            dwdSpiderJob.setEducation(eduLevel.toString());
            dwdSpiderJob.setExperience(experience.toString());

            if (EtlProps.IS_OPEN_WRITE_MYSQL){
                aListJob.add(dwdSpiderJob);
                aListCorp.add(dwdSpiderCorp);
            }

            if (EtlProps.IS_OPEN_WRITE_FILE){
                String jobInfo = JSON.toJSONString(dwdSpiderJob);
                String corpInfo = JSON.toJSONString(dwdSpiderCorp);
                try {
                    FileUtils.writeStringToFile(new File("./result_job.txt"),jobInfo+"\r\n","utf-8",true);
                    FileUtils.writeStringToFile(new File("./result_corp.txt"),corpInfo+"\r\n","utf-8",true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(jobInfo);
            }
        }
    }
}
