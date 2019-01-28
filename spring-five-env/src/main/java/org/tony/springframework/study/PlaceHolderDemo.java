package org.tony.springframework.study;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class PlaceHolderDemo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-context.xml");
        genericXmlApplicationContext.refresh();

        AppProperty appProperty =
                (AppProperty) genericXmlApplicationContext.getBean("appProperty");

        System.out.println("Application_home: " + appProperty.getApplicationHome());
        System.out.println("User_home: " + appProperty.getUserHome());
        genericXmlApplicationContext.close();
    }

}