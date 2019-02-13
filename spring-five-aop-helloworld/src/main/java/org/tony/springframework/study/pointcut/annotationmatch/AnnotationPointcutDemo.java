package org.tony.springframework.study.pointcut.annotationmatch;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.tony.springframework.study.pointcut.aspectjexp.SimpleAdvice;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.annotationmatch
 */
public class AnnotationPointcutDemo {

    public static void main(String... args) {
        Guitarist guitarist = new Guitarist();

        AnnotationMatchingPointcut matchingPointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(matchingPointcut,new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) factory.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

}
