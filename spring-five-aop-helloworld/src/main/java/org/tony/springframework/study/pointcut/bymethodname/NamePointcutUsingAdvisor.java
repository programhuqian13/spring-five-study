package org.tony.springframework.study.pointcut.bymethodname;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.bymethodname
 * @see org.springframework.aop.support.NameMatchMethodPointcutAdvisor
 * @see org.springframework.aop.support.NameMatchMethodPointcut
 */
public class NamePointcutUsingAdvisor {

    public static void main(String... args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.setMappedNames("sing");
        advisor.setMappedNames("rest");

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(grammyGuitarist);
        factory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) factory.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

}
