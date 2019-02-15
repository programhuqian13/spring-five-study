package org.tony.springframework.study.frameworkservice.aspectjstyleannotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.aspectjstyleannotation
 */
public class AspectAnnotationTest {

    @Test
    public void xmlTest() {
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-aspectj-context.xml");
        genericXmlApplicationContext.refresh();

        NewDocumentarist documentarist = genericXmlApplicationContext.getBean("documentarist", NewDocumentarist.class);

        documentarist.execute();

        genericXmlApplicationContext.close();
    }

    @Test
    public void annotationTest(){
        GenericApplicationContext genericApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        NewDocumentarist newDocumentarist = genericApplicationContext.getBean("documentarist", NewDocumentarist.class);

        newDocumentarist.execute();

        genericApplicationContext.close();
    }

}
