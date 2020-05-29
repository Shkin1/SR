package com.sr.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class DwdSpiderJob {
    private String uuid;

    private String searchKey;

    private String position;

    private String salary;

    private String salaryType;

    private String salaryLowest;

    private String salaryHighest;

    private String education;

    private String experience;

    private String positionPeoples;

    private String welfareTag;

    private String summaryTag;

    private String city;

    private String cityCode;

    private String cityDetail;

    private String publishDate;

    private String url;

    private Date createTime;

    private String positionDesc;
}