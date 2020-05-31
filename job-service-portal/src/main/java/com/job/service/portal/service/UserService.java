package com.job.service.portal.service;

import com.job.service.common.exception.SrException;
import com.job.service.persist.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/05/31 10:00
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface UserService {
    UserModel getUser(Integer id);

    UserModel register(UserModel registerUser) throws SrException, UnsupportedEncodingException, NoSuchAlgorithmException;

    UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, SrException;

    Integer countAllUser();
}
