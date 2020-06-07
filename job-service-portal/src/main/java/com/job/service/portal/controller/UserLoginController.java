package com.job.service.portal.controller;

import com.job.service.common.exception.SrException;
import com.job.service.common.restful.CommonRes;
import com.job.service.common.restful.LoginReq;
import com.job.service.persist.model.UserModel;
import com.job.service.portal.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/05/31 9:13
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

@RestController
@RequestMapping(value = {"/user"})
@Api(description = "用户登陆接口")
public class UserLoginController {

    @Autowired
    private UserService userLoginService;

//    @RequestMapping("/")
//    public String controller(){
//        return "/userLogin";
//    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @PostMapping(value = {"/userLogin"})
    @ResponseBody
    public CommonRes userLogin(@Valid @RequestBody LoginReq loginReq, HttpServletRequest request)  {

        UserModel userModel = null;
        try {
            userModel = userLoginService.login(loginReq.getTelphone(),loginReq.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonRes.create("登陆失败");
        }

        if (userModel != null) {
            //登录成功
            //将用户信息放入session
            request.getSession().setAttribute("session_user", userModel);
            return CommonRes.create("登陆成功");
        }
        return CommonRes.create("登陆失败");
    }

//    @RequestMapping(value = {"/registerpage"})
//    public String registerpage(){
//        return "register";
//    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @PostMapping(value = {"/register"})
    public CommonRes addUser(@Valid @RequestBody UserModel registerUser) throws UnsupportedEncodingException, SrException, NoSuchAlgorithmException {
        UserModel register = userLoginService.register(registerUser);
        if (register.getId() == null) {
                return CommonRes.create("注册失败");
            } else {
                return CommonRes.create("注册成功");
            }

    }
}
