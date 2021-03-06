package com.lc.clz;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

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
//@EnableDistributedTransaction /*开启分布式事务管理*/
public class BasicService {
    
    public static void main(String[] args){
       /* System.out.println("基础服务提供者服务开始启动");
        System.out.println("请输入端口号，为避免端口号重复，提供者服务请以9000端口开始，禁止使用占用端口启动...");
        Scanner scanner=new Scanner(System.in);
        String port=scanner.nextLine();
        new SpringApplicationBuilder(BasicProvider.class).properties("server.port="+9000).run(args);*/
        new SpringApplicationBuilder(BasicService.class).run(args);
    }
}
