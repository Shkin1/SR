package com.job.service.persist.model;

import lombok.Data;

import java.util.Date;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/11 19:05
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Data
public class DwdSpiderJobIndex {
    private Integer id;

    private String uuid;

    private String key;

    private String jobName;

    private String companyName;

    private String addressCity;

    private String addressArea;

    private String addressProvince;

    private String salary;

    private String publishDate;

    private String url;

    private Date createTime;
}