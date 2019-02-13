package org.tony.springframework.study.pointcut.controlflow;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.controlflow
 */
public class ControlFlowDemo {

    public static void main(String... args) {
        ControlFlowDemo controlFlowDemo = new ControlFlowDemo();
        controlFlowDemo.run();
    }

    public void run() {
        TestBean target = new TestBean();

        /***
         * 我们正在为ControlFlowDemo类的test()方法创建一个ControlFlowPointcut实例。
         * 本质上，这就是说，切入点是所有从ControlFlowExample.test()方法中调用的方法。
         * 请注意，虽然我们说过切入点所有方法，但实际上这实际上意味着在代理对象上的切入点所有方法，
         * 这些方法使用与ControlFlowPointcut实例对应的Advisor建议使用。
         *
         */
        Pointcut pointcut = new ControlFlowPointcut(ControlFlowDemo.class,"test");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,new SimpleBeforeAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisor(advisor);

        TestBean proxy = (TestBean) factory.getProxy();
        System.out.println("\tTrying normal invoke");
        proxy.foo();
        System.out.println("\n\tTrying under ControlFlowDemo.test()");
        test(proxy);

    }

    private void test(TestBean proxy) {
        proxy.foo();
    }

}
