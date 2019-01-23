package org.tony.springframework.study.understandbeannaming;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming
 */
public class BeanNamingTest {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-understandbeannaming-context.xml");
        genericXmlApplicationContext.refresh();

        //genericXmlApplicationContext.getBeansOfType(String.class)
        //所有的bean类型为String，id，name
        //id属性在整个ApplicationContext中是唯一的，可以使用别名进行区分
        Map<String,String> beans = genericXmlApplicationContext.getBeansOfType(String.class);
        beans.entrySet().stream().forEach(b -> System.out.println(b.getKey()));
        genericXmlApplicationContext.close();
    }

}
