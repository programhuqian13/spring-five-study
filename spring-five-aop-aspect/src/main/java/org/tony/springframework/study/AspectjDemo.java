package org.tony.springframework.study;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class AspectjDemo {

    public static void main(String [] args) {
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-aspectj-context.xml");
        genericXmlApplicationContext.refresh();

        MessageWriter messageWriter = new MessageWriter();
        messageWriter.writeMessage();
        messageWriter.foo();

        genericXmlApplicationContext.close();
    }

}
