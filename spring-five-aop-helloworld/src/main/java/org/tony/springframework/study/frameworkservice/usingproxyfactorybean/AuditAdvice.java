package org.tony.springframework.study.frameworkservice.usingproxyfactorybean;


import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybean
 */
public class AuditAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("Executing: " + method);
    }
}
