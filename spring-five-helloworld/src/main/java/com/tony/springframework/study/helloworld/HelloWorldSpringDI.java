package com.tony.springframework.study.helloworld;

import com.tony.springframework.study.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 使用spring的依赖注入
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.helloworld
 */
public class HelloWorldSpringDI {

    public static void main(String ... args){
        //加载spring的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app-context.xml");
        //加载相应bean
        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer.render();
    }

}
