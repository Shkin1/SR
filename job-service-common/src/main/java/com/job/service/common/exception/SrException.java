package com.job.service.common.exception;

import com.job.service.common.restful.SrCommonError;
import com.job.service.common.restful.SrErrorEnum;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 10:03
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class SrException extends Exception {
    private SrCommonError srCommonError;

    public SrException(SrErrorEnum srErrorEnum){
        super();
        this.srCommonError = new SrCommonError(srErrorEnum);
    }

    public SrException(SrErrorEnum srErrorEnum, String errMsg){
        super();
        this.srCommonError = new SrCommonError(srErrorEnum);
        this.srCommonError.setErrMsg(errMsg);
    }

    public SrCommonError getSrCommonError() {
        return srCommonError;
    }

    public void setSrCommonError(SrCommonError srCommonError) {
        this.srCommonError = srCommonError;
    }
}
