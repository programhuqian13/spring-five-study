package org.tony.springframework.study.config2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.xml.MessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config2
 */
public class JavaConfig {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer messageRenderer = (MessageRenderer) applicationContext.getBean("messageRenderer");
        messageRenderer.render();
    }

}
