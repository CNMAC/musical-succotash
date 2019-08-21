package com.mooyle.concurrent.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TheadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> {
                log.info("task: {}", index);
            });
        }

        executorService.shutdown();
    }
}
