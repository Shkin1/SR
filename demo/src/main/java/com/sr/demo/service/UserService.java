package com.sr.demo.service;

import com.sr.demo.model.UserModel;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 10:00
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface UserService {
    UserModel getUser(Integer id);
}
