package org.tony.springframework.study.frameworkservice.usingproxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybean
 */
public class ProxyFactoryBeanDemo {

    public static void main(String... args) {
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-proxyfactory-context.xml");
        genericXmlApplicationContext.refresh();

        Documentarist documentarist = genericXmlApplicationContext.getBean("documentaristOne",Documentarist.class);

        Documentarist documentarist1 = genericXmlApplicationContext.getBean("documentaristTwo",Documentarist.class);

        System.out.println("Documentarist One >> ");
        documentarist.execute();

        System.out.println("\nDocumentarist Two >> ");
        documentarist1.execute();
    }

}
