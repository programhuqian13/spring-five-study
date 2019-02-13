package org.tony.springframework.study.pointcut.bymethodname;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.pointcutbymethodname
 * @see org.springframework.aop.support.NameMatchMethodPointcut
 */
public class NamePointcutDemo {

    public static void main(String... args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();

        NameMatchMethodPointcut matchMethodPointcut = new NameMatchMethodPointcut();
        matchMethodPointcut.addMethodName("sing");
        matchMethodPointcut.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(matchMethodPointcut,new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(grammyGuitarist);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();

        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

}
