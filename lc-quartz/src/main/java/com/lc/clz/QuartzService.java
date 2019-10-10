package com.lc.clz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class QuartzService {
    public static void main(String[] args){
        new SpringApplicationBuilder(QuartzService.class).run(args);
    }

}
