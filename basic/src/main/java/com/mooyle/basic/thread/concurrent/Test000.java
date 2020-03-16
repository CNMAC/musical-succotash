package com.mooyle.basic.thread.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test000 {

    private static String test;
    public static String getTest(){
        return test;
    }

    public static void main(String[] args) {
        Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
        for (long i = 0; i < 15; i++) {
            conMap.put(i, i + "");
        }

        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            long key = entry.getKey();
            if (key < 10) {
                conMap.remove(key);
            }
        }

        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
