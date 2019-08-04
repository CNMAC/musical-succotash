package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.NotRecommend;
import com.mooyle.concurrent.annotation.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    //懒汉模式加锁，不推荐
    private SingletonExample3(){

    }

    private static SingletonExample3 instance;

    public static synchronized SingletonExample3 getInstance(){
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
