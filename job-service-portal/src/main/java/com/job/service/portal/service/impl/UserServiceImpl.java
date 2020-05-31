package com.job.service.portal.service.impl;

import com.job.service.common.exception.SrException;
import com.job.service.common.restful.SrErrorEnum;
import com.job.service.common.util.CommonUtil;
import com.job.service.persist.mapper.portal.UserModelMapper;
import com.job.service.persist.model.UserModel;
import com.job.service.portal.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/05/31 10:01
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
        String encodePassword = CommonUtil.encodeByMd5(password);
        UserModel userModel = userModelMapper.selectByTelphoneAndPassword(telphone, encodePassword);
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
