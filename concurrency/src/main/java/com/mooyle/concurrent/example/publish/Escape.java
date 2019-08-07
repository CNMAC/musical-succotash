package com.mooyle.concurrent.example.publish;

import com.mooyle.concurrent.annotation.NotRecommend;
import com.mooyle.concurrent.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    // 对象逸出，一种错误的发布。当一个对象还没有构造完成时，就使他被其他线程所见
    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
