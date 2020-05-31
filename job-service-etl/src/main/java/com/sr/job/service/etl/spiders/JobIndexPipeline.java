package com.sr.job.service.etl.spiders;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import com.github.pagehelper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/10 18:03
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Component
@PipelineName(value="jobIndexPipeline")
public class JobIndexPipeline implements Pipeline<JobIndexBean> {

//    @Autowired
//    private DwdSpiderJobIndexService dwdSpiderJobIndexService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JobIndexPipeline.class);
    @Override
    public void process(JobIndexBean bean) {
        List<JobIndexHrefBean> categoryList = bean.getCategoryList();
        for (JobIndexHrefBean hrefBean : categoryList) {
            HttpRequest request = bean.getRequest();
            String url = hrefBean.getUrl();
            String title = hrefBean.getTitle();
            String address = hrefBean.getAddress();
            String salary = hrefBean.getSalary();
            String company = hrefBean.getCompany();
            String publishTime = hrefBean.getPublishTime();
            if (StringUtil.isNotEmpty(url)){
//                DwdSpiderJobIndex dwdSpiderJobIndex = new DwdSpiderJobIndex();
                HttpRequest httpRequest = request.subRequest(url);
                httpRequest.addParameter("title",title);
                httpRequest.addParameter("salary",salary);
                httpRequest.addParameter("company",company);
                httpRequest.addParameter("publishTime",publishTime);
                SchedulerContext.into(httpRequest);
//                LOGGER.info("title:{}, company:{}, address:{}, salary:{}, publishTime:{}, url:{}",title, company, address,salary, publishTime, url);
//
//                try {
//                    dwdSpiderJobIndex.setUuid(CommonUtil.encodeByMd5(url));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                dwdSpiderJobIndex.setJobName(title);
//                dwdSpiderJobIndex.setCompanyName(company);
//                dwdSpiderJobIndex.setSalary(salary);
//                dwdSpiderJobIndex.setPublishDate(publishTime);
//                dwdSpiderJobIndex.setUrl(url);
//                dwdSpiderJobIndex.setAddressArea(address);
//                String s = JSON.toJSONString(dwdSpiderJobIndex);
//                try {
//                    FileUtils.writeStringToFile(new File("./080200-python.txt"),s+"\r\n","utf-8",true);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(s);

            }
        }

        List<HrefBean> pageList = bean.getPageList();
        for (HrefBean hrefBean : pageList) {
            String nextStr = hrefBean.getTitle();
            if (("下一页").equals(nextStr)){
                HttpRequest request = bean.getRequest();
                String url = hrefBean.getUrl();
                HttpRequest httpRequest = request.subRequest(url);
                SchedulerContext.into(httpRequest);
                LOGGER.info("获取下一页 url:{}", url);
            }
        }


    }
}
