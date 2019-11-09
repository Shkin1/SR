package com.sr.demo.request;

import lombok.Data;

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
public class PageQuery {

    private Integer page = 1;

    private Integer size = 20;

}
