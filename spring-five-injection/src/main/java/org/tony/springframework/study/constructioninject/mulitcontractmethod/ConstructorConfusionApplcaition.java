package org.tony.springframework.study.constructioninject.mulitcontractmethod;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 多构造函数的返回不同类型
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject.mulitcontractmethod
 */
public class ConstructorConfusionApplcaition {

    public static void main(String ... args){
        GenericXmlApplicationContext genericApplicationContext = new GenericXmlApplicationContext();
        genericApplicationContext.load("classpath:spring/app-mulitconstrable-context.xml");
        genericApplicationContext.refresh();
        ConstructorConfusionAnnotation constructorConfusionAnnotation = (ConstructorConfusionAnnotation) genericApplicationContext.getBean("constructorConfusion");
        System.out.println(constructorConfusionAnnotation);
        genericApplicationContext.close();
    }

}
