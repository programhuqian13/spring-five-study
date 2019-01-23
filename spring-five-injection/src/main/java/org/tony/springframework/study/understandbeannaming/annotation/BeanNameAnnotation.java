package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
public class BeanNameAnnotation {

    @Configuration
    @ComponentScan("org.tony.springframework.study.understandbeannaming.annotation")
    public static class AnnotationConfig{}

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Map<String,Singer> beans = applicationContext.getBeansOfType(Singer.class);

        beans.entrySet().stream().forEach(b ->{
            System.out.println("id:" + b.getKey());
        });


    }

}
