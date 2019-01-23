package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
@Award
public @interface Trophy {

    @AliasFor(annotation = Award.class,attribute = "value")
    String[] name() default {};
}
