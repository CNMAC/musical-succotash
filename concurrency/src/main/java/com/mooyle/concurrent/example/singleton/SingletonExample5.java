package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {
    //懒汉模式
    private SingletonExample5(){

    }

    // volatile禁止指令重排
    private volatile static SingletonExample5 instance;

    public static SingletonExample5 getInstance(){
        if (instance == null) {
            synchronized (SingletonExample5.class){
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
            instance = new SingletonExample5();
        }
        return instance;
    }
}
