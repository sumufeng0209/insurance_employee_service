package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableEurekaClient
@SpringBootApplication
public class InsuranceEmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceEmployeeServiceApplication.class, args);
    }

}
