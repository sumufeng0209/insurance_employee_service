package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InsuranceEmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceEmployeeServiceApplication.class, args);
    }

}
