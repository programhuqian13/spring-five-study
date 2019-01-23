package org.tony.springframework.study.relovingdependency;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.relovingdependency
 */
public class DependOnDemo {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-resolcingdependy-content.xml");
        genericXmlApplicationContext.refresh();

        Singer johnMayer = genericXmlApplicationContext.getBean("johnMayer",Singer.class);
        johnMayer.sing();

        genericXmlApplicationContext.close();
    }

}
