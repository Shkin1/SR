package com.sr.job.service.etl.spiders;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/10 18:53
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Gecco(matchUrl="https://jobs.51job.com/{address}/{id}.html?s=01&t=0", pipelines="jobResultPipeline")
public class JobDetailBean implements HtmlBean {
    private static final long serialVersionUID = 123456789L;

    @Request
    private HttpRequest request;

    @Text
    @HtmlField(cssPath= "body > div.tCompanyPage > div.tCompany_center.clearfix > div.tHeader.tHjob > div > div.cn > h1")
    private String title;

    @Text
    @HtmlField(cssPath= "p.cname a.catn")
    private String company;

    @Text
    @HtmlField(cssPath="body > div.tCompanyPage > div.tCompany_center.clearfix > div.tHeader.tHjob > div > div.cn > strong")
    private String salary;

    @Text
    @HtmlField(cssPath = "div.bmsg.job_msg.inbox p")
    private List<String> jobDesc;

    @Text
    @HtmlField(cssPath = "div.tmsg.inbox")
    private String companyDesc;

    @Text
    @HtmlField(cssPath = "p.msg.ltype")
    private List<String> typeDesc;


    @Text
    @HtmlField(cssPath = "div.t1 span")
    private List<String> fuliTag;

    @Href
    @HtmlField(cssPath = "div.com_msg a.com_name.himg")
    private String companyUrl;

    @Text
    @HtmlField(cssPath = "div.com_tag p:nth-child(1)")
    private String companyType;


    @Text
    @HtmlField(cssPath = "div.com_tag p:nth-child(2)")
    private String companyPeople;

    @Text
    @HtmlField(cssPath = "div.com_tag p:nth-child(3) a")
    private List<String> companyTrade;

    public HttpRequest getRequest() {
        return request;
    }


    public List<String> getFuliTag() {
        return fuliTag;
    }

    public void setFuliTag(List<String> fuliTag) {
        this.fuliTag = fuliTag;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(List<String> jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public List<String> getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(List<String> typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyPeople() {
        return companyPeople;
    }

    public void setCompanyPeople(String companyPeople) {
        this.companyPeople = companyPeople;
    }

    public List<String> getCompanyTrade() {
        return companyTrade;
    }

    public void setCompanyTrade(List<String> companyTrade) {
        this.companyTrade = companyTrade;
    }
}
