package org.tony.springframework.study.pointcut.aspectjexp;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.aspectjexppointcut
 */
public class AspectjexpPointcutDemo {

    public static void main(String... args){
        Guitarist guitarist = new Guitarist();

        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression("execution(* sing*(..))");

        Advisor advisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut,new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) factory.getProxy();
        proxy.sing();
        proxy.sing1();
        proxy.rest();
        proxy.talk();
    }

}
