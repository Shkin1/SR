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
}