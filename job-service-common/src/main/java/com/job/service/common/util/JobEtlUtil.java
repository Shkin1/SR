package com.job.service.common.util;

import com.job.service.common.constant.EduEnum;
import com.job.service.common.constant.SalaryEnum;
import com.job.service.persist.model.DwdSpiderJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/16 16:32
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public class JobEtlUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobEtlUtil.class);

    private static final String SALARY_W = "万";
    private static final String SALARY_Q = "千";
    private static final String SALARY_Y = "元";
    private static final int SALARY_W_FLAG = 1;
    private static final int SALARY_Q_FLAG = 2;
    private static final int SALARY_Y_FLAG = 3;
    private static final String SALARY_REGEX = "-";
    private static final String PP_PREFIX = "招";
    private static final String PP_SUFFIX = "人";
    private static final String PP_RG = "若干";
    private static final String CITY_AREA = "区";


    /**
     * 清洗学历字段.
     * @param oldString 待洗数据
     * @return 学历等级
     */
    public static Integer getEduLevel(String oldString){
        Integer eduLevel = EduEnum.EDU_NULL.getEduCode();
        if (oldString.contains(EduEnum.EDU_BS.getEduName())){
            eduLevel = EduEnum.EDU_BS.getEduCode();
        }
        if (oldString.contains(EduEnum.EDU_YJS.getEduName())){
            eduLevel = EduEnum.EDU_YJS.getEduCode();
        }
        if (oldString.contains(EduEnum.EDU_YJS_P.getEduName())){
            eduLevel = EduEnum.EDU_YJS_P.getEduCode();
        }
        if (oldString.contains(EduEnum.EDU_BK.getEduName())){
            eduLevel = EduEnum.EDU_BK.getEduCode();
        }
        if (oldString.contains(EduEnum.EDU_DZ.getEduName())){
            eduLevel = EduEnum.EDU_DZ.getEduCode();
        }
        if (oldString.contains(EduEnum.EDU_ZZ.getEduName())){
            eduLevel = EduEnum.EDU_ZZ.getEduCode();
        }
        // 取最低学历
        return eduLevel;
    }

    /**
     * 清洗薪水类型字段.
     * @param oldStr 待洗数据
     * @return 薪水类型
     */
    public static String getSalayType(String oldStr){
        String salayType = SalaryEnum.SALY_NULL.getTypeFlag().toString();
        if (oldStr.contains(SalaryEnum.SALY_DAY.getType()) || oldStr.contains(SalaryEnum.SALY_DAY_P.getType())){
            salayType = SalaryEnum.SALY_DAY.getTypeFlag().toString();
        }else if(oldStr.contains(SalaryEnum.SALY_MONTH.getType())){
            salayType = SalaryEnum.SALY_MONTH.getTypeFlag().toString();
        }else if(oldStr.contains(SalaryEnum.SALY_YEAR.getType())){
            salayType = SalaryEnum.SALY_YEAR.getTypeFlag().toString();
        }
        return salayType;
    }

    public static String getPositionPeoples(String oldStr){
        String resultStr = null;
        try{
            resultStr = oldStr.substring(oldStr.indexOf(PP_PREFIX) + 1, oldStr.indexOf(PP_SUFFIX)).replace(PP_RG,"3");
        }catch (StringIndexOutOfBoundsException e){
            LOGGER.warn("{} - 无法清洗PositionPeoples字段",oldStr);
        }
        return resultStr;
    }

    public static String getTags(String oldStr){

        HashMap<String, String> addMap = AddressUtil.initAddDictMap();
        Set<Map.Entry<String, String>> entries = addMap.entrySet();
        // 标准化城市tag
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            if (oldStr.contains(key+"-")){
                oldStr.replace(key+"-",key+" ");
            }else if (oldStr.contains(key)){
                oldStr.replace(key,key+" ");
            }
        }
        // 标准化地区tag
        if (oldStr.contains(CITY_AREA)){
            oldStr.replace(CITY_AREA,CITY_AREA+" ");
        }
        // 标准化工作经验标签
        if (oldStr.contains(CITY_AREA)){
            oldStr.replace(CITY_AREA,CITY_AREA+" ");
        }
        // TODO other tag
        return oldStr;
    }


    public static void getSalayRange(String oldStr, DwdSpiderJob dwdSpiderJob){
        String salayLowest;
        String salayHighest;
        if (StringUtils.isEmpty(oldStr)){
            return;
        }
        int salaryUnitFlag = 0;
        if (oldStr.contains(SALARY_Y)){
            salaryUnitFlag = SALARY_Y_FLAG;
        }else if (oldStr.contains(SALARY_Q)){
            salaryUnitFlag = SALARY_Q_FLAG;
        }else if (oldStr.contains(SALARY_W)){
            salaryUnitFlag = SALARY_W_FLAG;
        }
        String newStr = oldStr.replace("万/月", "")
                .replace("千/月","")
                .replace("万/年","")
                .replace("元/天","");

        if (newStr.contains(SALARY_REGEX)){
            String[] newStrList = newStr.split("-");
            salayLowest = newStrList[0];
            salayHighest = newStrList[1];
            DecimalFormat df = new DecimalFormat("0.00");
            if (salaryUnitFlag == SALARY_Q_FLAG){
                Double d1 = Double.parseDouble(salayLowest) * 1000;
                Double d2 = Double.parseDouble(salayHighest) * 1000;
                salayLowest = df.format(d1);
                salayHighest = df.format(d2);
            }else if(salaryUnitFlag == SALARY_W_FLAG){
                Double d1 = Double.parseDouble(salayLowest) * 10000;
                Double d2 = Double.parseDouble(salayHighest) * 10000;
                salayLowest = df.format(d1);
                salayHighest = df.format(d2);
            }
        }else {
            salayLowest = newStr;
            salayHighest = newStr;
        }
        dwdSpiderJob.setSalaryLowest(salayLowest);
        dwdSpiderJob.setSalaryHighest(salayHighest);
    }

    // --TODO 待优化
    public static Integer getExperience(String oldString){
        Integer experience = 0;

        if (oldString.contains("1年")){
            experience = 1;
        }else if (oldString.contains("2年")){
            experience = 2;
        }else if (oldString.contains("2 年")){
            experience = 2;
        }else if (oldString.contains("3年")){
            experience = 3;
        }else if (oldString.contains("4年")){
            experience = 4;
        }else if (oldString.contains("5年")){
            experience = 5;
        }else if (oldString.contains("6年")){
            experience = 6;
        }else if (oldString.contains("7年")){
            experience = 7;
        }else if (oldString.contains("8年")){
            experience = 8;
        }else if (oldString.contains("9年")){
            experience = 9;
        }

        if (oldString.contains("10-15年")){
            experience = 10;
        }else if (oldString.contains("8-9年")){
            experience = 8;
        }else if (oldString.contains("5-10年")){
            experience = 5;
        }else if (oldString.contains("5-8年")){
            experience = 5;
        }else if (oldString.contains("5-7年")){
            experience = 5;
        }else if (oldString.contains("5-6年")){
            experience = 5;
        }else if (oldString.contains("4-5年")){
            experience = 4;
        }else if (oldString.contains("3-4年") || oldString.contains("3-5年")){
            experience = 3;
        }else if (oldString.contains("2-3年") || oldString.contains("2-4年")|| oldString.contains("2-5年")){
            experience = 2;
        }else if (oldString.contains("1-3年") || oldString.contains("1-2年")){
            experience = 1;
        }

        if (oldString.contains("3-4年") || oldString.contains("3 -4年")|| oldString.contains("3 - 4年")|| oldString.contains("3- 4年")){
            experience = 3;
        }

        if (oldString.contains("5-7年") || oldString.contains("5 -7年")|| oldString.contains("5 - 7年")|| oldString.contains("5- 7年")){
            experience = 5;
        }
        return experience;
    }

}
