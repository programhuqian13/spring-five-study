package org.tony.springframework.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybean
 */
public class MessageDigestDemo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-factorybean-context.xml");
        genericXmlApplicationContext.refresh();

        MessageDigester digester = genericXmlApplicationContext.getBean("messageDigest",MessageDigester.class);
        digester.digest("hello world!");
        genericXmlApplicationContext.close();
    }
}
