package com.lc.clz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //服务客户端，让该服务注册到Eureka中
public class QuartzService {
    public static void main(String[] args){
        new SpringApplicationBuilder(QuartzService.class).run(args);
    }

}
