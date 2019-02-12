package org.tony.springframework.study;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.inter.MessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class Jsr330Demo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-jsr330-context.xml");
        genericXmlApplicationContext.refresh();

        MessageRenderer messageRenderer = genericXmlApplicationContext.getBean("messageRenderer",MessageRenderer.class);

        messageRenderer.render();

        genericXmlApplicationContext.close();
    }

}
