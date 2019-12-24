package com.sr.demo.etl;

import com.alibaba.fastjson.JSONArray;
import com.sr.demo.model.DwdSpiderJobIndex;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/14 22:49
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public class test {
    public static void main(String[] args) throws IOException {


//        String s1 = "机器学习";
//        String sr = URLEncoder.encode(s1,"UTF-8").replace("%","%25");
//
//        System.out.println(sr);

//        String s2 = "java";
////        String gbk = URLEncoder.encode(s2.replace("%25", "%"), "GBK");
////        System.out.println(gb);
//
//        String decode = URLDecoder.decode(s2.replace("%25", "%"));
//        System.out.println(decode);

        String oldStr = "杭州-西湖区3-4年经验大专招210-22发布";

        String substring = null;
        try{
            substring = oldStr.substring(oldStr.indexOf("招") + 1, oldStr.indexOf("人"));
        }catch (StringIndexOutOfBoundsException e){

            System.out.println(oldStr+"无法转换");
        }

        System.out.println(substring);

    }
}
