package com.example.demo2.controllers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @EnableScheduling
public class jobCheck {

    @GetMapping("/api/check")
    public String scheduleMyJob() {
        return "Job Scheduled";
    }
}
