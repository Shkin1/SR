package com.job.service.persist.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/05/31 10:05
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

@Data
public class UserModel implements Serializable{
    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private String telphone;

    private String password;

    private String nickName;

    private Integer gender;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 经验
     */
    private Integer experience;

    /**
     * 擅长技术
     */
    private String techTag;

    /**
     * 期望职位
     */
    private String position;

    /**
     * 工作地点
     */
    private String cityCode;



}