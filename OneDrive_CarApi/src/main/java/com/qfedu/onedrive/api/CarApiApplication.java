package com.qfedu.onedrive.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: OneDrive
 * @ClassName: CarApiApplication
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-16 21:38
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class CarApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarApiApplication.class,args);
    }
}
