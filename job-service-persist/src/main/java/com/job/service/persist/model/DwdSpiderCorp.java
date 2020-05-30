package com.job.service.persist.model;

import lombok.Data;

import java.util.Date;

@Data
public class DwdSpiderCorp {
    private String uuid;

    private String name;

    private String type;

    private String peoples;

    private String tradeTag;

    private String url;

    private Date createTime;

    private String info;
}