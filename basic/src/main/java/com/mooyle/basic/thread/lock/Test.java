package com.mooyle.basic.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res {
    public String name;
    public int age;
    public boolean flag = false;
    Lock lock = new ReentrantLock();
}

class TestWrite extends Thread {
    Res res;
    Condition condition;

    public TestWrite(Res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                res.lock.lock();
                if(res.flag){
                    condition.await();
                }
                if (count == 0) {
                    res.name = "小美";
                    res.age = 18;
                } else {
                    res.name = "小明";
                    res.age = 24;
                }
                count = (count + 1) % 2;
                res.flag = true;
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

class TestRead extends Thread {
    Res res;
    Condition condition;

    public TestRead(Res res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        while(true){
            try {
                res.lock.lock();
                if(!res.flag){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + ":" + String.valueOf(res.age));
                res.flag = false;
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }

        }
    }
}

public class Test {
    public static void main(String[] args) {
        Res res = new Res();
        Condition condition = res.lock.newCondition();
        Thread th1 = new TestWrite(res, condition);
        Thread th2 = new TestRead(res, condition);

        th1.start();
        th2.start();
    }

}
