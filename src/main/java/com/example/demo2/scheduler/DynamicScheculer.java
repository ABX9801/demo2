package com.example.demo2.scheduler;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class DynamicScheculer implements SchedulingConfigurer {

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // TODO Auto-generated method stub
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("TRY TO SCHEDULE JOB");
                        System.out.println("SCHEDULED MY JOB");
                    }
                },

                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext context) {
                        Optional<Date> lastCompletionTime = Optional.ofNullable(context.lastCompletionTime());
                        // fetch the frequency
                        // convert in seconds
                        // pass the value
                        Instant nextExecutionTime = lastCompletionTime.orElseGet(Date::new).toInstant()
                                .plusSeconds(10);
                        return Date.from(nextExecutionTime);
                    }
                });

    }

}