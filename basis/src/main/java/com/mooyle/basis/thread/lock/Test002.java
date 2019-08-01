package com.mooyle.basis.thread.lock;

public class Test002 {
    public static void main(String[] args) {
        Test002 test002 = new Test002();
        long l1 = 129809;
        System.out.println(test002.getClass(l1));
    }

    public <T>  String getClass(T value){
        Class<?> s1 = value.getClass();
        if (s1 == long.class || s1 == Long.class){
            return "Long type";
        }else {
            return "else type";
        }
    }
}
