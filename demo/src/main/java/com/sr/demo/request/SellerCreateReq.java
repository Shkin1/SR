package com.sr.demo.request;

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
public class SellerCreateReq {
    @NotBlank(message = "商户名不能为空")
    private String name;
}
