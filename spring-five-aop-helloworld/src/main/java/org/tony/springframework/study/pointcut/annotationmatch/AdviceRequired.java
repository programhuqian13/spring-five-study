package org.tony.springframework.study.pointcut.annotationmatch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 以注解的方式定义切面
 * 通过一个@interface定义一个接口的注解
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.annotationmatch
 */
@Retention(RetentionPolicy.RUNTIME) //注解的保留位置 runtime:注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.TYPE, ElementType.METHOD})  //定义注释可以应用于类型或方法级别
public @interface AdviceRequired {
}
