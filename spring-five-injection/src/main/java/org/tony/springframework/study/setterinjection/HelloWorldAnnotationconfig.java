package org.tony.springframework.study.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tony.springframework.study.message.MessageRenderer;
import org.tony.springframework.study.setterinjection.config.SetterInjectAnnotationConfig;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection
 */
public class HelloWorldAnnotationconfig {

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SetterInjectAnnotationConfig.class);
        MessageRenderer messageRenderer = applicationContext.getBean("renderer",MessageRenderer.class);
        messageRenderer.render();
    }

}
