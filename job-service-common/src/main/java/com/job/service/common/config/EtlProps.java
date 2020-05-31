package com.job.service.common.config;

/**
 * @author shijinpu
 * @version v1.0.0
 * @date 2019/12/17 9:33
 * <p>Description: 爬虫参数类
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */


public class EtlProps {

    /**
     * 爬虫结果是否开启写入mysql数据库.
     */
    public static final Boolean IS_OPEN_WRITE_MYSQL = true;

    /**
     * 爬虫结果是否开启写入文件.
     */
    public static final Boolean IS_OPEN_WRITE_FILE = false;

    /**
     * 爬虫爬取的关键字.
     */
    public static final String JOB_SEARCH_KEY = "python,java,数据分析,大数据,机器学习,区块链,人工智能";

//    public static final String JOB_SEARCH_KEY = "python,php,hadoop,spark,scala,c,c++,c#,软件开发,数据分析,大数据,机器学习,区块链,人工智能";

}
