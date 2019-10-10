package com.lc.clz.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class QuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            quartzScheduler.startAllJob();
            System.out.println("任务已启动！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public Scheduler scheduler() throws SchedulerException{
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }

}
