package org.tony.springframework.study.config5;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.xml.MessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config5
 */
public class JavaConfigRun {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        MessageRenderer messageRenderer =
                applicationContext.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer.render();
    }

}
