package com.inshare.concurrency.example.publish;

import com.inshare.concurrency.annoation.NotRecommend;
import com.inshare.concurrency.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class  InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
