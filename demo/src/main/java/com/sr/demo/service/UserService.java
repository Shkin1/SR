package com.sr.demo.service;

import com.sr.demo.common.SrException;
import com.sr.demo.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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

    UserModel register(UserModel registerUser) throws SrException, UnsupportedEncodingException, NoSuchAlgorithmException;

    UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, SrException;

    Integer countAllUser();
}
