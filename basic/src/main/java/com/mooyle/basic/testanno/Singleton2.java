package com.mooyle.basic.testanno;

public class Singleton2 {

    private static volatile Singleton2 instance = null;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
