package org.tony.springframework.study.pointcut.regular;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.regularpointcut
 */
public class RegexPointcutDemo {

    public static void main(String... args){
        Guitarist guitarist = new Guitarist();

        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPattern(".*sing.*");

        Advisor advisor = new DefaultPointcutAdvisor(jdkRegexpMethodPointcut,new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(guitarist);
        factory.addAdvisor(advisor);

        Guitarist proxy = (Guitarist) factory.getProxy();

        proxy.sing();
        proxy.sing1();
        proxy.rest();
        proxy.talk();
    }

}
