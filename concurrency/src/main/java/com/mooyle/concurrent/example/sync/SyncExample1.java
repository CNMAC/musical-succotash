package com.mooyle.concurrent.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample1 {

    // 修饰代码块，作用于对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰方法，作用于对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncExample1 syncExample1 = new SyncExample1();
        SyncExample1 syncExample2 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.execute(() -> {
//            syncExample1.test1(1);
//        });
//        executorService.execute(() -> {
//            syncExample1.test1(1);
//        });
        executorService.execute(() -> {
            syncExample1.test1(1);
        });
        executorService.execute(() -> {
            syncExample2.test1(2);
        });
        executorService.execute(() -> {
            syncExample1.test2(1);
        });
        executorService.execute(() -> {
            syncExample2.test2(2);
        });
        executorService.shutdown();

    }
}
