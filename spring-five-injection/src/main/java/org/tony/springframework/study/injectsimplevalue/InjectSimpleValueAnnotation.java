package org.tony.springframework.study.injectsimplevalue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.injectsimplevalue.config.InjectSimpleAnnotationConfig;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
public class InjectSimpleValueAnnotation {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InjectSimpleAnnotationConfig.class);
        InjectSimpleAnnotaion injectSimple = (InjectSimpleAnnotaion) applicationContext.getBean("injectSimple");
        System.out.println(injectSimple);
    }

}
