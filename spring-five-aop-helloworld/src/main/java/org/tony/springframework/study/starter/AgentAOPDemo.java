package org.tony.springframework.study.starter;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 * @see org.springframework.aop.framework.ProxyFactory
 */
public class AgentAOPDemo {

    public static void main(String... args) {
        Agent agent = new Agent();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator()); //给aop添加切面
        proxyFactory.setTarget(agent);  //给aop添加目标对象

        Agent proxyObject = (Agent) proxyFactory.getProxy();

        agent.speak();
        System.out.println("");
        proxyObject.speak();

    }

}
