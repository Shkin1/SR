package com.sr.job.service.etl.spiders;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.SpiderBean;


/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/11 9:35
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public class JobIndexHrefBean implements SpiderBean {

    private static final long serialVersionUID = -1770871271092767593L;

    @Href
    @HtmlField(cssPath="p.t1 span a")
    private String url;

    @Text
    @HtmlField(cssPath="p.t1 span a")
    private String title;

    @Text
    @HtmlField(cssPath="span.t3")
    private String address;

    @Text
    @HtmlField(cssPath="span.t2 a")
    private String company;

    @Text
    @HtmlField(cssPath="span.t4")
    private String salary;

    @Text
    @HtmlField(cssPath="span.t5")
    private String publishTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}