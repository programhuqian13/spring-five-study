package org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro.annotation.AppConfig;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro
 */
public class IntroducationAnnotationDemo {

    public static void main(String... args) {
        GenericApplicationContext genericApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Contact bean = (Contact) genericApplicationContext.getBean("bean");
        IsModified isModified = (IsModified) bean;

        System.out.println("Is Contact?: " + (bean instanceof Contact));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));

        System.out.println("Has bean modified?: " + isModified.isModified());
        bean.setName("Tony");

        System.out.println("Has been modified?: " + isModified.isModified());
        bean.setName("Qian Hu");

        System.out.println("Has been modified?: " + isModified.isModified());
    }

}
