package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.ThreadSafe;

@ThreadSafe
public class SingletonExample2 {
    //饿汉模式, 缺点：加载慢，资源浪费
    private SingletonExample2(){

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
