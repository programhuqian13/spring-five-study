package org.tony.springframework.study.frameworkservice.usingaopnamespace;


import org.aspectj.lang.JoinPoint;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingaopnamespace
 */
public class SimpleAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing: " +
                joinPoint.getSignature().getDeclaringTypeName() + " " +
                joinPoint.getSignature().getName());
    }
}
