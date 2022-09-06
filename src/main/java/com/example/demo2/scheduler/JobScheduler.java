package com.example.demo2.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {
    @Scheduled(cron = "0 37 01 * * *")
    public void cronJobSch() {
        System.out.println("SCHEDULED JOB IS RUNNING");
    }
}
