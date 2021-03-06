package org.tony.springframework.study.injectcollect;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by tony on 2019/1/19.
 */
public class CollectInjectApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-injectcollect-context.xml");
        genericXmlApplicationContext.refresh();

        CollectInject collectInject = (CollectInject) genericXmlApplicationContext.getBean("collectInject");
        collectInject.displayInfo();
        genericXmlApplicationContext.close();
    }

}
