package org.tony.springframework.study.advice.afterreturningadvice.demo2;

import java.util.Random;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.afterreturningadvice.demo2
 */
public class KeyGenerator {

    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0xACDF03F590AE56L;

    private Random rand = new Random();

    public long getKey() {
        int x = rand.nextInt(3);
        if (x == 1){
            return WEAK_KEY;
        }

        return STRONG_KEY;
    }

}
