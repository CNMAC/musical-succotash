package com.mooyle.basis.thread.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test001 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.printf("线程名称%s, 订单号：%s\n", Thread.currentThread().getName(), getOrderNumber());
                }
            });
        }
        latch.countDown();
    }

    public static synchronized String getOrderNumber() {
        return new SimpleDateFormat("yyyyMMddHHmmss SSS").format(new Date());

    }
}
