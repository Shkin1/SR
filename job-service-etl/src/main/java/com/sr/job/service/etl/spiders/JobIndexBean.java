package com.sr.job.service.etl.spiders;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/10 16:56
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Gecco(matchUrl="https://search.51job.com/list/{addCode},000000,0000,00,9,99,{key},2,{page}.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=", pipelines="jobIndexPipeline")
public class JobIndexBean implements HtmlBean {
    private static final long serialVersionUID = -7127412585200687225L;

    @Request
    private HttpRequest request;

    @HtmlField(cssPath="div.el")
    private List<JobIndexHrefBean> categoryList;

    /**
     * 上一页 1,2,3,4,5,6 下一页
     */
    @HtmlField(cssPath="div.p_in ul li")
    private List<HrefBean> pageList;

    public List<HrefBean> getPageList() {
        return pageList;
    }

    public Annotation[] getAnno(){
        Class<JobIndexBean> jobIndexBeanClass = JobIndexBean.class;
        Annotation[] annotations = jobIndexBeanClass.getAnnotations();
        return annotations;

    }

    public void setPageList(List<HrefBean> pageList) {
        this.pageList = pageList;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<JobIndexHrefBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<JobIndexHrefBean> categoryList) {
        this.categoryList = categoryList;
    }
}
