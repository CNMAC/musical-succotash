package com.mooyle.basis.thread.sync;


class Res1 {
    public String name;
    public int age;
    public boolean flag = false;
}

class TestWrite1 extends Thread {
    Res1 res;
    public TestWrite1(Res1 res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res){
                if(res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                res.notify();
            }

        }
    }
}

class TestRead1 extends Thread {
    Res1 res;

    public TestRead1(Res1 res) {
        this.res = res;
    }

    @Override
    public void run() {
        while(true){
            synchronized (res){
                if(!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + ":" + String.valueOf(res.age));
                res.flag = false;
                res.notify();
            }
        }
    }
}

public class Test1 {
    public static void main(String[] args) {
        Res1 res = new Res1();
        Thread th1 = new TestWrite1(res);
        Thread th2 = new TestRead1(res);
        th1.start();
        th2.start();
    }

}
