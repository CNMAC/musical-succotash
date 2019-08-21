package com.mooyle.concurrent.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TheadPoolExample4 {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(() -> {
            log.warn("schedule run1");
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.warn("schedule run2");
        }, 1, 3, TimeUnit.SECONDS);

        //single thread
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 2000);
    }
}
