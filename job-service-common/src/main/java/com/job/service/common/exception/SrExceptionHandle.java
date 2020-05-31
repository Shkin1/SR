package com.job.service.common.exception;

import com.job.service.common.restful.CommonRes;
import com.job.service.common.restful.SrCommonError;
import com.job.service.common.restful.SrErrorEnum;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/11/8 23:20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

@ControllerAdvice
public class SrExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonRes doError(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse, Exception ex){
        if(ex instanceof SrException){
            return CommonRes.create(((SrException)ex).getSrCommonError(),"fail");
        }
        else if(ex instanceof NoHandlerFoundException){
            SrCommonError commonError = new SrCommonError(SrErrorEnum.NO_HANDLER_FOUND);
            return CommonRes.create(commonError,"fail");
        }else if(ex instanceof ServletRequestBindingException){
            SrCommonError commonError = new SrCommonError(SrErrorEnum.BIND_EXCEPTION_ERROR);
            return CommonRes.create(commonError,"fail");
        }
        else {
            SrCommonError commonError = new SrCommonError(SrErrorEnum.UNKNOWN_ERROR);
            return CommonRes.create(commonError,"fail");
        }

    }
}
