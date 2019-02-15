package org.tony.springframework.study.frameworkservice.usingaopnamespace;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingaopnamespace
 */
public class AopNamespaceDemo {

    public static void main(String... args) {
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-aopnamespace-context.xml");
        genericXmlApplicationContext.refresh();

        NewDocumentarist newDocumentarist = genericXmlApplicationContext.getBean("documentarist", NewDocumentarist.class);
        newDocumentarist.execute();

        genericXmlApplicationContext.close();
    }

}
