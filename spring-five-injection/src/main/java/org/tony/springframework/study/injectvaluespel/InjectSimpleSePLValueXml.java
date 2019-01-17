package org.tony.springframework.study.injectvaluespel;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.injectsimplevalue.InjectSimple;

/**
 * @Description 通过SePL表达式设置值
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
public class InjectSimpleSePLValueXml {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-inject-simple-context.xml");
        genericXmlApplicationContext.refresh();
        InjectSimpleSpEL injectSimple = (InjectSimpleSpEL) genericXmlApplicationContext.getBean("injectSePL");
        System.out.println(injectSimple);
        genericXmlApplicationContext.close();
    }

}
