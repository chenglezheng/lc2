package com.lc.clz.controller;

import com.lc.clz.service.JobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 */
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     *初始化启动所有的Job
     */
    @PostConstruct
    public void initializeJob() {
        jobService.initializeJob();
    }

    /**
     * 根据ID重启某个Job
     * @param id
     * @return
     * @throws SchedulerException
     */
    @RequestMapping("/refreshJob")
    public String refreshJob(@RequestParam("id") Integer id){
        return jobService.refreshJob(id);
    }

    /**
     *重启数据库中所有的Job
     */
    @RequestMapping("/refresh/allJob")
    public String refreshAll() {
        return jobService.refreshAll();
    }


    /**
     *测试
     */
    @RequestMapping("/test")
    public String test() {
        return "success";
    }

}
