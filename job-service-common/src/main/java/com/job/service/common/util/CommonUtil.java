package com.job.service.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/8 23:43
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class CommonUtil {
    public static String processErrorString(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(FieldError fieldError:bindingResult.getFieldErrors()){
            // 将request的对象校验的message拼接起来
            stringBuilder.append(fieldError.getDefaultMessage()+",");
        }
        // 删除最后一个,
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确认计算方法MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }

    public static String encodeParam(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str,"UTF-8").replace("%","%25");
    }

    public static String decodeParam(String str){
        return URLDecoder.decode(str.replace("%25", "%"));
    }

}
