package com.mooyle.basis.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class Test001 {
    public static void main(String[] args) throws Exception{
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        System.out.println("我是主线程");
        new Thread(new Runnable() {
            public void run() {
                System.out.println("我是子线程，开始执行任务......");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("我是子线程，开始执行任务......");
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println("我是子线程，开始执行任务......");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("我是子线程，开始执行任务......");
            }
        }).start();
        countDownLatch.await();//如果不为0,一直等待
        System.out.println("主线程开始执行任务");
    }
}
