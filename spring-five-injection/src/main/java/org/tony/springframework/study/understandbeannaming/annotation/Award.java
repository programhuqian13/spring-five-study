package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * @Description 定义相关的注解
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
public @interface Award {

    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};


}
