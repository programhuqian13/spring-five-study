package org.tony.springframework.study.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tony.springframework.study.message.MessageRenderer;

/**
 * @Description 通过xml配置文件的方式加载bean
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection
 */
public class HelloWorldXmlconfig {

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/app-context.xml");
        MessageRenderer messageRenderer = applicationContext.getBean("renderer",MessageRenderer.class);
        messageRenderer.render();
    }

}
