package org.tony.springframework.study.fieldinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description field 注入的方式
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.fieldinject
 */
public class FieldApplication {

    public static void main(String ... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FieldConfig.class);
        Singer singer = (Singer) applicationContext.getBean("singer");
        singer.sing();
    }

}
