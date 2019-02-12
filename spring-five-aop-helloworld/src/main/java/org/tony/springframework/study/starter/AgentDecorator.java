package org.tony.springframework.study.starter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description MethodInterceptor接口是一个标准的AOP联盟接口，用于实现关于方法调用连接点的通知
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 * @see org.aopalliance.intercept.MethodInterceptor
 */
public class AgentDecorator implements MethodInterceptor {

    /**
     * MethodInvocation对象表示所建议的方法调用，使用这个对象，我们可以控制方法调用何时被允许进行
     * 因为这是关于通知的(around advice)，所以我们能够在方法被调用之前以及在方法被调用之后但是在它返回之前执行操作
     *
     * @param methodInvocation
     * @return
     * @throws Throwable
     * @see org.aopalliance.intercept.MethodInvocation
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Tony ");

        Object retval = methodInvocation.proceed();

        System.out.println("!");
        return retval;
    }
}
