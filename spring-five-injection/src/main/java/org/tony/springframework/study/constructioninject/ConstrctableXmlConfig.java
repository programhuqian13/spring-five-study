package org.tony.springframework.study.constructioninject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tony.springframework.study.jms.message.MessageRenderer;

/**
 * @Description 构造函数注入xml配置读取
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject
 */
public class ConstrctableXmlConfig {

    public static void main(String ... args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/app-constrable-context.xml");
        MessageRenderer renderer = applicationContext.getBean("renderer",MessageRenderer.class);
        renderer.render();

    }

}
