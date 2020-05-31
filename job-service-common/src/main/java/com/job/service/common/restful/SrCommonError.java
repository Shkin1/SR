package com.job.service.common.restful;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/8 23:32
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class SrCommonError {

    private Integer errCode;
    private String errMsg;

    public SrCommonError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public SrCommonError(SrErrorEnum srErrorEnum) {
        this.errCode = srErrorEnum.getErrCode();
        this.errMsg = srErrorEnum.getErrMsg();
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
