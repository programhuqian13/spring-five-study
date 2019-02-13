package org.tony.springframework.study.pointcut.regular;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description 创建一个advice
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.regularpointcut
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoked " + methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        System.out.println(">> Done!\n");
        return returnValue;
    }
}
