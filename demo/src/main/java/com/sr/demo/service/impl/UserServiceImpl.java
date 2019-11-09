package com.sr.demo.service.impl;

import com.sr.demo.common.SrErrorEnum;
import com.sr.demo.common.SrException;
import com.sr.demo.mapper.UserModelMapper;
import com.sr.demo.model.UserModel;
import com.sr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 10:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserModel register(UserModel registerUser) throws SrException {
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());
        try{
            userModelMapper.insertSelective(registerUser);
        } catch (DuplicateKeyException){
            throw new SrException(SrErrorEnum.REGISTER_DUP_FAIL);
        }
        return getUser(registerUser.getId());
    }

    private String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确认计算方法MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }
}
