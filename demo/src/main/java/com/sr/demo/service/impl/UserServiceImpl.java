package com.sr.demo.service.impl;

import com.sr.demo.mapper.UserModelMapper;
import com.sr.demo.model.UserModel;
import com.sr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
