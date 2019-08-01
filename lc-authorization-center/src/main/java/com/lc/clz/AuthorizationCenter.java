package com.lc.clz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //服务客户端，让该服务注册到Eureka中
@EnableFeignClients  //Feign客户端
@EnableCircuitBreaker  //熔断机制
public class AuthorizationCenter {

    public static void main(String[] args){
        new SpringApplicationBuilder(AuthorizationCenter.class).run(args);
    }

}
