package com.sr.demo.common;

import java.util.HashMap;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/11 12:47
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public class AddressUtil {

    /**
     * 缓存省份字典.
     * @return 省份字典
     */
    public static HashMap<String, String> initAddDictMap(){
        HashMap<String, String> addressDictMap = new HashMap<>(16);
        addressDictMap.put("全国","000000");
        addressDictMap.put("北京","010000");
        addressDictMap.put("上海","020000");
        addressDictMap.put("广州","030200");
        addressDictMap.put("深圳","040000");
        addressDictMap.put("南京","070200");
        addressDictMap.put("杭州","080200");
        return addressDictMap;
    }
}
