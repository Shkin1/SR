package com.sr.demo.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
}
