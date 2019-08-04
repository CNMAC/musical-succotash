package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.NotThreadSafe;

@NotThreadSafe
public class SingletonExample4 {
    //懒汉模式
    private SingletonExample4(){

    }
    // 初始化对象2、3步骤，可能指令重排
    // 1、分配对象内存空间
    // 2、初始化对象
    // 3、设置instance指向分配内存

    private static SingletonExample4 instance;

    public static SingletonExample4 getInstance(){
        if (instance == null) {
            synchronized (SingletonExample4.class){
                if (instance == null) {
                    instance = new SingletonExample4(); //指令重排位置
                }
            }
            instance = new SingletonExample4();
        }
        return instance;
    }
}
