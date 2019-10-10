package com.lc.clz.scheduler;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzScheduler {

    @Autowired
    private Scheduler scheduler;

    /**
     * 执行所有调度任务
     * @throws SchedulerException
     */
    public void startAllJob() throws SchedulerException{
        startJobTest(scheduler);
        scheduler.start();
    }

    /**
     * 开始某一调度任务
     * @throws SchedulerException
     */
    private void startJobTest(Scheduler scheduler) throws SchedulerException{
        //通过JobBuilder构建JobDetail实例，JobDetail规定只能是Job接口的实例
        //JobDetail是具体Job实例
        JobDetail jobDetail=JobBuilder.newJob(QuartzJobTest.class).withIdentity("jobtest","grouptest").build();
        //基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //CronTrigger表达式触发器 继承Trigger
        //TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger=TriggerBuilder.newTrigger().withIdentity("jobtest","grouptest")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);

    }
}
