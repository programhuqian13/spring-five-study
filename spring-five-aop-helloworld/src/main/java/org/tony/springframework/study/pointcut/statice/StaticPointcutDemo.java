package org.tony.springframework.study.pointcut.statice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.staticpointcut.demo1
 * @see org.springframework.aop.framework.ProxyFactory
 * @see org.springframework.aop.Pointcut
 * @see org.springframework.aop.Advisor
 * @see org.aopalliance.aop.Advice
 * @see org.springframework.aop.support.DefaultPointcutAdvisor
 */
public class StaticPointcutDemo {

    public static void main(String... args) {
        GoodGuitarist goodGuitarist = new GoodGuitarist();
        GreatGuitarist greatGuitarist = new GreatGuitarist();

        Singer proxyOne;
        Singer proxyTwo;

        //创建一个切入点
        Pointcut pointcut = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(goodGuitarist);

        proxyOne = (Singer) factory.getProxy();

        factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(greatGuitarist);
        proxyTwo = (Singer) factory.getProxy();

        proxyOne.sing();
        proxyTwo.sing();

    }
}
