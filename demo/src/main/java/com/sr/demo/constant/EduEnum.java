package com.sr.demo.constant;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/16 16:05
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public enum  EduEnum {

    // 无
    EDU_NULL("无",0),
    //中专
    EDU_ZZ("中专",1),
    //大专
    EDU_DZ("大专",2),
    //本科
    EDU_BK("本科",3),
    //研究生
    EDU_YJS("研究生",4),
    EDU_YJS_P("硕士",4),
    //博士
    EDU_BS("博士",5);

    private String eduName;
    private Integer eduCode;

    EduEnum(String eduName, Integer eduCode) {
        this.eduName = eduName;
        this.eduCode = eduCode;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public Integer getEduCode() {
        return eduCode;
    }

    public void setEduCode(Integer eduCode) {
        this.eduCode = eduCode;
    }
}
