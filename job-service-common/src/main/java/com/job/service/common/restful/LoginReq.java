package com.job.service.common.restful;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 19:51
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Data
public class LoginReq {
    @NotBlank(message = "手机号不能为空")
    private String telphone;
    @NotBlank(message = "密码不能为空")
    private String password;
}
