package org.tony.springframework.study.injectsimplevalue;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
public class InjectSimpleValueXml {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-inject-simple-context.xml");
        genericXmlApplicationContext.refresh();
        InjectSimple injectSimple = (InjectSimple) genericXmlApplicationContext.getBean("injectSimple");
        System.out.println(injectSimple);
        genericXmlApplicationContext.close();
    }

}
