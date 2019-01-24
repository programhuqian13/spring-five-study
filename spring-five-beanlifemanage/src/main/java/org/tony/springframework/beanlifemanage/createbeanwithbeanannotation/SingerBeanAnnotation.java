package org.tony.springframework.beanlifemanage.createbeanwithbeanannotation;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.createbeanwithbeanannotation
 */
public class SingerBeanAnnotation {

    @Configuration
    @ComponentScan("org.tony.springframework.beanlifemanage.createbeanwithbeanannotation")
    public static class SingerBeanAnnotationConfig{

        @Lazy
        @Bean(initMethod = "init")
        public Singer singerOne(){
            Singer singer = new Singer();
            singer.setName("tony");
            singer.setAge(16);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        public Singer singerTwo(){
            Singer singer = new Singer();
            singer.setAge(55);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        public Singer singerThree(){
            Singer singer = new Singer();
            singer.setName("tony");
            return singer;
        }

    }

    public static Singer getBean(String name, ApplicationContext applicationContext){
        try{
            Singer singer = (Singer) applicationContext.getBean(name);
            System.out.println(singer);
            return singer;
        }catch (BeanCreationException e){
            System.out.println("创建bean的时候配置出现异常" + e.getMessage());
            return null;
        }
    }

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(SingerBeanAnnotationConfig.class);

        getBean("singerOne",genericApplicationContext);
        getBean("singerTwo",genericApplicationContext);
        getBean("singerThree",genericApplicationContext);

        genericApplicationContext.close();


    }

}
