package com.job.service.common.constant;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/16 19:27
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public enum  SalaryEnum {
    // 无
    SALY_NULL("无",0),
    //日
    SALY_DAY("日",1),
    //天
    SALY_DAY_P("天",1),
    //月
    SALY_MONTH("月",2),
    //年
    SALY_YEAR("年",3);


    private String type;
    private Integer typeFlag;

    SalaryEnum(String type, Integer typeFlag) {
        this.type = type;
        this.typeFlag = typeFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(Integer typeFlag) {
        this.typeFlag = typeFlag;
    }
}
