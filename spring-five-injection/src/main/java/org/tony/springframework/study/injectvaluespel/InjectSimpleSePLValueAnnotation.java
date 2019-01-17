package org.tony.springframework.study.injectvaluespel;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.injectvaluespel.config.InjectValueAnnotationConfig;

/**
 * @Description 通过SePL表达式设置值
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
public class InjectSimpleSePLValueAnnotation {

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(InjectValueAnnotationConfig.class);
        InjectSimpleSpELAnnotation injectSimpleSpELAnnotation =
                (InjectSimpleSpELAnnotation) applicationContext.getBean("injectSimpleSpELAnnotation");
        System.out.println(injectSimpleSpELAnnotation);

    }

}
