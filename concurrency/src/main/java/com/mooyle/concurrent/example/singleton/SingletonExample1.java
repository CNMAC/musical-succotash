package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.NotThreadSafe;

@NotThreadSafe
public class SingletonExample1 {
    //懒汉模式 非线程安全
    private SingletonExample1(){

    }

    private static SingletonExample1 instance;

    public static SingletonExample1 getInstance(){
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
