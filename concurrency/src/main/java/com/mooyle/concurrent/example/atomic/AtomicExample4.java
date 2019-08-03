package com.mooyle.concurrent.example.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class AtomicExample4 {

    @Getter
    public volatile int count = 100;

    private static AtomicIntegerFieldUpdater<AtomicExample4> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample4.class, "count");

    private static AtomicExample4 example4 = new AtomicExample4();

    public static void main(String[] args) {
        if(updater.compareAndSet(example4, 100, 120)){
            log.info("update success 1, {}", example4.getCount());
        }
        if(updater.compareAndSet(example4, 100, 120)){
            log.info("update success 2, {}", example4.getCount());
        }else {
            log.info("update failed, {}", example4.getCount());
        }
    }

}
