package com.tony.springframeworld.study.helloworld;

import com.tony.springframeworld.study.config.HelloWorldConfig;
import com.tony.springframeworld.study.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Author xuanyi@baofu.com
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframeworld.study.helloworld
 */
public class HelloWorldAnnotations {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        MessageRenderer renderer = applicationContext.getBean("messageRenderer",MessageRenderer.class);
        renderer.render();
    }

}
