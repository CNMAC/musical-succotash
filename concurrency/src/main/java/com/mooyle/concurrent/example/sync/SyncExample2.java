package com.mooyle.concurrent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample2 {

    // 修饰类，作用于所有对象
    public void test1(int j) {
        synchronized (SyncExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰静态方法，作用于所有对象
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncExample2 syncExample1 = new SyncExample2();
        SyncExample2 syncExample2 = new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            syncExample1.test1(1);
        });
        executorService.execute(() -> {
            syncExample2.test1(2);
        });
        executorService.execute(() -> {
            SyncExample2.test2(1);
        });
        executorService.execute(() -> {
            SyncExample2.test2(2);
        });
        executorService.shutdown();

    }
}
