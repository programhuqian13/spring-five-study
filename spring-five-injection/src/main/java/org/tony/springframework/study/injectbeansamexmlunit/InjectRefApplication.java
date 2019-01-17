package org.tony.springframework.study.injectbeansamexmlunit;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 在相同的XML单元中注入bean
 * 需要注意的重要一点是，被注入的类型不必是在目标上定义的确切类型;
 * 类型只需要兼容即可。兼容意味着如果目标上声明的类型是接口，
 * 则注入的类型必须实现此接口。
 * 如果声明的类型是一个类，那么注入的类型必须是相同的类型或子类型
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectbeansamexmlunit
 */
public class InjectRefApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-inject-same-xml-context.xml");
        genericXmlApplicationContext.refresh();
        InjectRef injectRef = (InjectRef) genericXmlApplicationContext.getBean("injectRef");
        System.out.println(injectRef);
        genericXmlApplicationContext.close();
    }

}
