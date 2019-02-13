package org.tony.springframework.study.advice.afterreturningadvice.demo1;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.afterreturningadvice
 * @see org.springframework.aop.AfterReturningAdvice
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    public static void main(String... args) {
        Guitarist target = new Guitarist();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new SimpleAfterReturningAdvice());
        factory.setTarget(target);

        Guitarist guitarist = (Guitarist) factory.getProxy();
        guitarist.sing();
    }


    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object o1) throws Throwable {
        System.out.println("After '" + method.getName() + "' put down guitar.");
    }
}
