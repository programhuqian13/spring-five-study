package org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro
 */
public class IntroducationConfigDemo {

    public static void main(String... args) {
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-proxyfactoryintro-context.xml");
        genericXmlApplicationContext.refresh();

        Contact bean = (Contact) genericXmlApplicationContext.getBean("bean");
        IsModified isModified = (IsModified) bean;

        System.out.println("Is Contact?: " + (bean instanceof Contact));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));

        System.out.println("Has bean modified?: " + isModified.isModified());
        bean.setName("Tony");

        System.out.println("Has been modified?: " + isModified.isModified());
        bean.setName("Qian Hu");

        System.out.println("Has been modified?: " + isModified.isModified());

        genericXmlApplicationContext.close();
    }

}
