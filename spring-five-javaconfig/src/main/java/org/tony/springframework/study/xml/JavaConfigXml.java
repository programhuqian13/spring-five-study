package org.tony.springframework.study.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.xml
 */
public class JavaConfigXml {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-xml-context.xml");
        genericXmlApplicationContext.refresh();

        MessageRenderer messageRenderer =
                (MessageRenderer) genericXmlApplicationContext.getBean("messageRenderer");
        messageRenderer.render();
    }

}