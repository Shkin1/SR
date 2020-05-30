package com.job.service.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/30 17:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@SpringBootApplication
@MapperScan(basePackages = "com.job.service.persist.mapper")
public class JobServicePortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobServicePortalApplication.class, args);
    }
}
