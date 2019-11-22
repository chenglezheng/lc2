package com.lc.clz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableEurekaClient   //注册服务
@EnableFeignClients  //Feign
@EnableCircuitBreaker  //开启熔断
@EnableAuthorizationServer //认证服务器
public class AuthorizationCenter {

    public static void main(String[] args){
        new SpringApplicationBuilder(AuthorizationCenter.class).run(args);
    }

}
