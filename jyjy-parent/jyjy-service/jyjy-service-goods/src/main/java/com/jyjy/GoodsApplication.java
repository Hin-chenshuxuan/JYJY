package com.jyjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient //开启Eureka客户端
@EnableFeignClients(basePackages = {"com.jyjy.user.feign"})
@MapperScan(basePackages = "com.jyjy.goods.dao") //开启通用Mapper的包扫描
@EnableSwagger2
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}

