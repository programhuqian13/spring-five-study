package org.tony.springframework.study.autowiringbean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.autowiringbean
 */
public class Target {

    private Foo fooOne;

    private Foo fooTwo;

    private Bar bar;

    public Target(){}

    public Target(Foo foo){
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo,Bar bar){
        System.out.println("Target(Foo,Bar) called");
    }

    public void setFooOne(Foo fooOne){
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo foo){
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar){
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-autowiringbean-content.xml");
        genericXmlApplicationContext.refresh();

        Target target = null;
        System.out.println("Using byName: \n");
        target = (Target) genericXmlApplicationContext.getBean("targetByName");

        System.out.println("Using byType: \n");
        target = (Target) genericXmlApplicationContext.getBean("targetByType");

        System.out.println("Using byConstructor:\n");
        target = (Target) genericXmlApplicationContext.getBean("targetConstructor");

        genericXmlApplicationContext.close();
    }

}
