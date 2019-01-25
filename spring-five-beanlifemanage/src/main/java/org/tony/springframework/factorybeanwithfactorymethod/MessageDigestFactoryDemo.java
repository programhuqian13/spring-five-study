package org.tony.springframework.factorybeanwithfactorymethod;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.factorybean.MessageDigester;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybeanwithfactorymethod
 */
public class MessageDigestFactoryDemo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-factorybeanfactorymethod-context.xml");
        genericXmlApplicationContext.refresh();

        MessageDigester messageDigester =
                genericXmlApplicationContext.getBean("messageDigest",MessageDigester.class);

        messageDigester.digest("Hello world!");

        genericXmlApplicationContext.close();
    }

}
