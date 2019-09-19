package com.qfedu.onedrive.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: OneDrive
 * @ClassName: CarServerApplication
 * @description: TODO
 * @author: ccq
 * @create: 2019-09-16 21:27
 **/
@SpringBootApplication
@MapperScan("com.qfedu.onedrive.server.dao")
@EnableDiscoveryClient
public class CarServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class,args);
    }
}
