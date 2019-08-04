package com.mooyle.concurrent.example.singleton;

import com.mooyle.concurrent.annotation.Recommend;
import com.mooyle.concurrent.annotation.ThreadSafe;

//枚举模式
@ThreadSafe
@Recommend
public class SingletonExample6 {

    private SingletonExample6(){

    }

    public static SingletonExample6 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample6 singleton;

        Singleton(){
            singleton = new SingletonExample6();
        }

        public SingletonExample6 getSingleton(){
            return singleton;
        }
    }
}
