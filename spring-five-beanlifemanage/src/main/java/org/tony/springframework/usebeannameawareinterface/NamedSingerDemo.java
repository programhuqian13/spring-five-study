package org.tony.springframework.usebeannameawareinterface;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.usebeannameawareinterface
 */
public class NamedSingerDemo {

    public static void main(String ... args){

        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-beannameaware-context.xml");
        genericXmlApplicationContext.refresh();

        NamedSinger namedSinger = (NamedSinger) genericXmlApplicationContext.getBean("johnMayer");
        namedSinger.sing();

        genericXmlApplicationContext.close();

    }

}
