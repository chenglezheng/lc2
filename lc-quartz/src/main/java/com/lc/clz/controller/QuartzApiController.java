package com.lc.clz.controller;

import com.lc.clz.scheduler.QuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartzApiController {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @RequestMapping("/startAllJob")
    public void startQuartzJob() {
        try {
            quartzScheduler.startAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
