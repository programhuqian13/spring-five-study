package org.tony.springframework.study.understandbeannaming;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

/**
 * @Description 使用别名，在使用别名的时候，name和id都可以使用多个 但是这里有一个不同之处：
 * 在使用name多个值的时候，匹配的第一个将是id，后面的其他值将作为别名
 * 在使用id多个值的时候，id为多个id，但是没有一个是别名
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming
 */
public class BeanNameAliasTest {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-beannamealias-context.xml");
        genericXmlApplicationContext.refresh();

        String s1 = (String) genericXmlApplicationContext.getBean("john");
        String s2 = (String) genericXmlApplicationContext.getBean("johnny");
        String s3 = (String) genericXmlApplicationContext.getBean("jonathan");
        String s4 = (String) genericXmlApplicationContext.getBean("jim");
        String s5 = (String) genericXmlApplicationContext.getBean("ion");

        System.out.println((s1 == s2));
        System.out.println((s2 == s3));
        System.out.println((s3 == s4));
        System.out.println((s4 == s5));

        Map<String,String> beans = genericXmlApplicationContext.getBeansOfType(String.class);
        if(beans.size() == 1){
            System.out.println("这只是一个string bean");
        }

        genericXmlApplicationContext.close();
    }
}
