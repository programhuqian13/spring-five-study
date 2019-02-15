package org.tony.springframework.study.frameworkservice.usingaopnamespace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingaopnamespace
 */
public class ComplexAdvice {

    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if (value.getBrand().equals("Tony")) {
            System.out.println("Executing: " +
                    joinPoint.getSignature().getDeclaringTypeName() + " " +
                    joinPoint.getSignature().getName());
        }
    }

    //添加around advice
    public Object simpleAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Guitar value) throws Throwable {
        System.out.println("Before execution: " +
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " +
                proceedingJoinPoint.getSignature().getName() +
                " argument: " + value.getBrand());

        Object retvalue = proceedingJoinPoint.proceed();

        System.out.println("After execution: " +
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " +
                proceedingJoinPoint.getSignature().getName() +
                " argument: " + value.getBrand());

        return retvalue;
    }

}
