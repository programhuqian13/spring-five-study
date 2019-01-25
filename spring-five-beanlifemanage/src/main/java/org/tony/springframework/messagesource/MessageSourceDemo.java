package org.tony.springframework.messagesource;

import org.springframework.cglib.core.Local;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.messagesource
 */
public class MessageSourceDemo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-messagesourcedemo-context.xml");
        genericXmlApplicationContext.refresh();

        Locale english = Locale.ENGLISH;
        Locale china = Locale.CHINA;

        System.out.println(
                genericXmlApplicationContext.getMessage("msg",null,english));
        System.out.println(
                genericXmlApplicationContext.getMessage("msg",null,china));

        System.out.println(
                genericXmlApplicationContext.getMessage("nameMag",
                        new Object[]{"tony","shanghai"},english)
        );

        System.out.println(
                genericXmlApplicationContext.getMessage("nameMag",
                        new Object[]{"tony","shanghai"},china)
        );

        genericXmlApplicationContext.close();
    }

}
