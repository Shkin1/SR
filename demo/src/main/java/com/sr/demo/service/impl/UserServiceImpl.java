package com.sr.demo.service.impl;

import com.sr.demo.common.CommonUtil;
import com.sr.demo.common.SrErrorEnum;
import com.sr.demo.common.SrException;
import com.sr.demo.mapper.UserModelMapper;
import com.sr.demo.model.UserModel;
import com.sr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
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

    @Resource
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserModel register(UserModel registerUser) throws SrException, UnsupportedEncodingException, NoSuchAlgorithmException {
        registerUser.setPassword(CommonUtil.encodeByMd5(registerUser.getPassword()));
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());
        try{
            userModelMapper.insertSelective(registerUser);
        } catch (DuplicateKeyException ex){
            throw new SrException(SrErrorEnum.REGISTER_DUP_FAIL);
        }
        return getUser(registerUser.getId());
    }

    @Override
    public UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, SrException {
        UserModel userModel = userModelMapper.selectByTelphoneAndPassword(telphone, CommonUtil.encodeByMd5(password));
        if(userModel == null){
            throw new SrException(SrErrorEnum.LOGIN_FAIL);
        }
        return userModel;
    }

    @Override
    public Integer countAllUser() {
        return userModelMapper.countAllUser();
    }

}
