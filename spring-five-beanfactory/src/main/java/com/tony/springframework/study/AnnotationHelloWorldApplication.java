package com.tony.springframework.study;

import com.tony.springframework.study.message.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.core
 */
public class AnnotationHelloWorldApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/app-annotation-config.xml");
        context.refresh();
        MessageRenderer messageRenderer = context.getBean("renderer",MessageRenderer.class);
        messageRenderer.render();
        context.close();
    }

}
