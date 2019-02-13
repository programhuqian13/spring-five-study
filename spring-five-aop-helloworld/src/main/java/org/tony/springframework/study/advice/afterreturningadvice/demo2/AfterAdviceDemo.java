package org.tony.springframework.study.advice.afterreturningadvice.demo2;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.afterreturningadvice.demo2
 */
public class AfterAdviceDemo {

    private static KeyGenerator getKeyGenerator() {

        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());

        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String... args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        for (int x = 0; x < 10; x++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException ex) {
                System.out.println("Weak Key Generated!");
            }
        }
    }

}
