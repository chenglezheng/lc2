package com.lc.clz;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by chenglezheng on 2018/12/28.
 */
@SpringBootApplication
@EnableEurekaClient  //服务客户端，让该服务注册到Eureka中
@EnableTransactionManagement /*开启事务管理*/
public class Notifaction {
    
    public static void main(String[] args){
        new SpringApplicationBuilder(Notifaction.class).run(args);
    }
}
