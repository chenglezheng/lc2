package com.lc.clz;

/*import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;*/

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by chenglezheng on 2018/12/28.
 */
@SpringBootApplication
@EnableEurekaClient  //服务客户端，让该服务注册到Eureka中
@EnableTransactionManagement /*开启事务管理*/
/*@EnableDistributedTransaction*/ /*开启分布式事务管理*/
@EnableCircuitBreaker  //熔断机制
@EnableFeignClients  //Feign客户端
public class UserCenter {
    public static void main(String[] args){
        new SpringApplicationBuilder(UserCenter.class).run(args);
    }
}
