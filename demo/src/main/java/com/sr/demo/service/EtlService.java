package com.sr.demo.service;

import java.io.File;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/16 17:06
 * <p>Company:浩鲸云计算科技股份有限公司 </p>
 * <p>Description:
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
public interface EtlService {

    void readFileToMysql(File fName);

}
