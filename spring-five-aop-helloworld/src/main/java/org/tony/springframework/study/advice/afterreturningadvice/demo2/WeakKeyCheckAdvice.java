package org.tony.springframework.study.advice.afterreturningadvice.demo2;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.afterreturningadvice.demo2
 */
public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {
        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();
            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException("Key Generated a weak key. Try again");
            }
        }
    }
}
