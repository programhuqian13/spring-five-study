package com.tony.springframework.study;

import com.tony.springframework.study.core.HelloWorldSpringConfigComscan;
import com.tony.springframework.study.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 加载配置bean
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.core
 */
public class HelloWorldJavaConfigBeanComscan {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldSpringConfigComscan.class);
        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer.render();
    }

}
