package org.tony.springframework.study.constructioninject.mulitcontractmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.constructioninject.mulitcontractmethod.config.ConstructorConfusionConfig;

/**
 * @Description 注解的方式
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject.mulitcontractmethod
 */
public class ConstructorConfusionAnnotationApplcaition {

    public static void main(String ... args){
        ApplicationContext genericApplicationContext =
                new AnnotationConfigApplicationContext(ConstructorConfusionConfig.class);
        ConstructorConfusionAnnotation constructorConfusionAnnotation = (ConstructorConfusionAnnotation) genericApplicationContext.getBean("constructorConfusion");
        System.out.println(constructorConfusionAnnotation);
    }

}
