package com.job.service.persist.model;

import java.util.Date;

public class DwdSpiderJobInfo {
    private Integer id;

    private String uuid;

    private String key;

    private String jobName;

    private String jobWelfareTag;

    private String jobSummaryTag;

    private String companyName;

    private String companyType;

    private String companyPeoples;

    private String companyTrade;

    private String companyUrlTag;

    private String addressCity;

    private String addressName;

    private String addressCode;

    private String jobSalary;

    private String publishDate;

    private String url;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobWelfareTag() {
        return jobWelfareTag;
    }

    public void setJobWelfareTag(String jobWelfareTag) {
        this.jobWelfareTag = jobWelfareTag == null ? null : jobWelfareTag.trim();
    }

    public String getJobSummaryTag() {
        return jobSummaryTag;
    }

    public void setJobSummaryTag(String jobSummaryTag) {
        this.jobSummaryTag = jobSummaryTag == null ? null : jobSummaryTag.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanyPeoples() {
        return companyPeoples;
    }

    public void setCompanyPeoples(String companyPeoples) {
        this.companyPeoples = companyPeoples == null ? null : companyPeoples.trim();
    }

    public String getCompanyTrade() {
        return companyTrade;
    }

    public void setCompanyTrade(String companyTrade) {
        this.companyTrade = companyTrade == null ? null : companyTrade.trim();
    }

    public String getCompanyUrlTag() {
        return companyUrlTag;
    }

    public void setCompanyUrlTag(String companyUrlTag) {
        this.companyUrlTag = companyUrlTag == null ? null : companyUrlTag.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode == null ? null : addressCode.trim();
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary == null ? null : jobSalary.trim();
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}