package com.mooyle.basis.thread.concurrent;

import java.util.concurrent.Semaphore;

class Parent implements Runnable {
    Semaphore wc;
    String name;
    public Parent(Semaphore wc, String name){
        this.wc = wc;
        this.name = name;
    }
    public void run() {
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0 ) {
            System.out.println(name +"还有"+availablePermits+"个茅坑");
        }else{
            System.out.println(name + "没有茅坑了...");
        }
        try {
            wc.acquire();
            System.out.println(name + "开始上厕所了");
            Thread.sleep(10000);
            System.out.println(name + "上完厕所了");
            wc.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test004 {
    public static void main(String[] args) {
        // 最多支持多少个资源访问
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 50; i++) {
            new Thread(new Parent(semaphore, "第"+i+"个: ")).start();
        }

    }
}
