package org.tony.springframework.study.pointcut.dynamic;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.dynamicpointcut
 */
public class DynamicPointcutDemo {

    public static void main(String... args) {
        SampleBean sampleBean = new SampleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(),new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(sampleBean);
        factory.addAdvisor(advisor);

        SampleBean proxySampleBean = (SampleBean) factory.getProxy();

        proxySampleBean.foo(1);
        proxySampleBean.foo(10);
        proxySampleBean.foo(100);

        proxySampleBean.bar();
        proxySampleBean.bar();
        proxySampleBean.bar();
    }

}
