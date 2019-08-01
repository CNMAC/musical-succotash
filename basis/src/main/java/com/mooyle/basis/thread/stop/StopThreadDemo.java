package com.mooyle.basis.thread.stop;

class TestStopThread extends Thread {

    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程执行开始...");
        while(flag){

        }
        System.out.println("子线程执行结束...");
    }

    public void stopThread(){
        this.flag = false;
    }
}

public class StopThreadDemo {

    public static void main(String[] args) throws Exception{
        TestStopThread testStopThread = new TestStopThread();
        testStopThread.start();
        for (int i = 1 ; i < 10; i++){
            System.out.println("我是主线程："+i);
            Thread.sleep(1000);
            if(i == 6){
                testStopThread.stopThread();
            }
        }
    }

}
