package org.tony.springframework.study.autowiringbean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.autowiringbean.annotation
 */
@Component
@Lazy
public class TrickyTarget {

    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget(){
        System.out.println("Tricky .contructor");
    }

    public TrickyTarget(Foo fooOne){
        this.fooOne = fooOne;
        System.out.println("Tricky(Foo) called");
    }

    public TrickyTarget(Foo fooOne,Bar bar){
        System.out.println("Tricky(Foo,Bar) called");
    }

    @Autowired
    public void setFooOne(Foo fooOne){
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    @Autowired
    public void setFooTwo(Foo fooTwo){
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar){
        this.bar = bar;
        System.out.println("Property bar set");
    }

    @Configuration
    @ComponentScan("org.tony.springframework.study.autowiringbean.annotation")
    public static class TrickyTargetConfig{}

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(TrickyTargetConfig.class);
        TrickyTarget trickyTarget = genericApplicationContext.getBean(TrickyTarget.class);
    }

}
