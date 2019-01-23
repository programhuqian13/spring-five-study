package org.tony.springframework.study.beaninheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beaninheritance
 */
public class BeanInheritanceApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-beaninheritance-context.xml");
        genericXmlApplicationContext.refresh();

        Singer parent = (Singer) genericXmlApplicationContext.getBean("parent");
        Singer child = (Singer) genericXmlApplicationContext.getBean("child");
        System.out.println("parent: " + parent);
        System.out.println("child: " + child);
        genericXmlApplicationContext.close();
    }

}
