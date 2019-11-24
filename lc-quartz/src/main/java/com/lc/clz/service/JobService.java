package com.lc.clz.service;

import com.lc.clz.entities.JobEntity;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author chenglezheng
 * @date 2019-11-22 14:35
 */
@Service
@Slf4j
public class JobService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private DynamicJobService dynamicJobService;

    public void initializeJob() {
        try {
            reStartAllJobs();
            log.info("INIT SUCCESS");
        } catch (SchedulerException e) {
            log.info("INIT EXCEPTION : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String refreshAll() {
        String result;
        try {
            reStartAllJobs();
            result = "SUCCESS";
        } catch (SchedulerException e) {
            result = "EXCEPTION : " + e.getMessage();
        }
        return "refresh all jobs : " + result;
    }


    public String refreshJob(Integer id){
        String result="";
        JobEntity entity = dynamicJobService.getJobEntityById(id);
        if (entity == null) return "error: id is not exist ";
        synchronized (log) {
            JobKey jobKey = dynamicJobService.getJobKey(entity);
            try {
                Scheduler scheduler = schedulerFactoryBean.getScheduler();
                scheduler.pauseJob(jobKey);
                scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
                scheduler.deleteJob(jobKey);
                JobDataMap map = dynamicJobService.getJobDataMap(entity);
                JobDetail jobDetail = dynamicJobService.geJobDetail(jobKey, entity.getDescription(), map);
                if (entity.getStatus().equals("OPEN")) {
                    scheduler.scheduleJob(jobDetail, dynamicJobService.getTrigger(entity));
                    result = "Refresh Job : " + entity.getName() + "\t jarPath: " + entity.getJarPath() + " success !";
                } else {
                    result = "Refresh Job : " + entity.getName() + "\t jarPath: " + entity.getJarPath() + " failed ! , " +
                            "Because the Job status is " + entity.getStatus();
                }
            }catch (SchedulerException se){
                se.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 重新启动所有的job
     * @throws SchedulerException
     */
    private void reStartAllJobs() throws SchedulerException {
        synchronized (log) {                                                         //只允许一个线程进入操作
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            Set<JobKey> set = scheduler.getJobKeys(GroupMatcher.anyGroup());
            scheduler.pauseJobs(GroupMatcher.anyGroup());                               //暂停所有JOB
            for (JobKey jobKey : set) {                                                 //删除从数据库中注册的所有JOB
                scheduler.unscheduleJob(TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup()));
                scheduler.deleteJob(jobKey);
            }
            for (JobEntity job : dynamicJobService.loadJobs()) {                               //从数据库中注册的所有JOB
                log.info("Job register name : {} , group : {} , cron : {}", job.getName(), job.getGroup(), job.getCron());
                JobDataMap map = dynamicJobService.getJobDataMap(job);
                JobKey jobKey = dynamicJobService.getJobKey(job);
                JobDetail jobDetail = dynamicJobService.geJobDetail(jobKey, job.getDescription(), map);
                if (job.getStatus().equals("OPEN")) scheduler.scheduleJob(jobDetail, dynamicJobService.getTrigger(job));
                else
                    log.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
            }
        }
    }


}
