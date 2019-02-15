package org.tony.springframework.study.frameworkservice.aspectjstyleannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.aspectjstyleannotation
 */
@Component
@Aspect
public class AnnotationAdvice {

    @Pointcut("execution(* org.tony.springframework.study." +
            "frameworkservice.aspectjstyleannotation..sing*" +
            "(org.tony.springframework.study.frameworkservice.aspectjstyleannotation.Guitar))" +
            "&& args(value)")
    public void singExecution(Guitar value) {

    }

    @Pointcut("bean(tony*)")
    public void isTony() {

    }

    @Before("singExecution(value) && isTony()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if (value.getBrand().equals("Tony")) {
            System.out.println("Executing: " +
                    joinPoint.getSignature().getDeclaringTypeName() + " " +
                    joinPoint.getSignature().getName() + " argument: " +
                    value.getBrand()
            );
        }
    }


    @Around("singExecution(value) && isTony()")
    public Object simpleAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, Guitar value) throws Throwable {
        System.out.println("Before Executing: " +
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " +
                proceedingJoinPoint.getSignature().getName() + " argument: " +
                value.getBrand()
        );

        Object retValue = proceedingJoinPoint.proceed();

        System.out.println("After Executing: " +
                proceedingJoinPoint.getSignature().getDeclaringTypeName() + " " +
                proceedingJoinPoint.getSignature().getName() + " argument: " +
                value.getBrand()
        );

        return retValue;
    }

}
