package org.tony.springframework.study.injectcollect;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by tony on 2019/1/19.
 */
public class CollectInjectAnnotationApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-injectcollect-annotation-context.xml");
        genericXmlApplicationContext.refresh();

        CollectInjectAnnotation collectInject = (CollectInjectAnnotation) genericXmlApplicationContext.getBean("collectInjectAnnotation");
        collectInject.displayInfo();
        genericXmlApplicationContext.close();
    }

}
