package org.tony.springframework.study.proxy;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.proxy
 */
public class ProxyPerfTest {

    public static void main(String... args) {
        SimpleBean simpleBean = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());

        runCglibTests(advisor, simpleBean);
        runCglibForzenTests(advisor, simpleBean);
        runJdkTests(advisor, simpleBean);

    }

    private static void runCglibTests(Advisor advisor, SimpleBean simpleBean) {
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(simpleBean);
        factory.setProxyTargetClass(true);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
    }

    private static void runCglibForzenTests(Advisor advisor, SimpleBean simpleBean) {
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(simpleBean);
        factory.setProxyTargetClass(true);
        factory.setFrozen(true);

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running CGLIB (Forzen) Tests");
        test(proxy);
    }

    private static void runJdkTests(Advisor advisor, SimpleBean simpleBean) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(simpleBean);
        factory.addAdvisor(advisor);
        factory.setInterfaces(new Class[]{SimpleBean.class});

        SimpleBean proxy = (SimpleBean) factory.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }

    private static void test(SimpleBean proxy) {
        long before = 0;
        long after = 0;

        System.out.println("Testing Advise Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            proxy.advised();
        }
        after = System.currentTimeMillis();

        System.out.println("Took " + (after - before) + " ms");

        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            proxy.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + " ms");

        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            proxy.equals(proxy);
        }
        after = System.currentTimeMillis();

        System.out.println("Took " + (after - before) + " ms");

        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            proxy.hashCode();
        }
        after = System.currentTimeMillis();

        System.out.println("Took " + (after - before) + " ms");

        Advised advised = (Advised) proxy;

        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 500000; x++) {
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();

        System.out.println("Took " + (after - before) + " ms");

        System.out.println(">>>\n");
    }
}
