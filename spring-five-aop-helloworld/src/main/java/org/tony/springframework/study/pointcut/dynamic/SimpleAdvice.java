package org.tony.springframework.study.pointcut.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.staticpointcut.demo1
 * @see MethodInterceptor
 */
public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking " + methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        System.out.println(">> Done\n");
        return retVal;
    }
}
