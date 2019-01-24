package org.tony.springframework.beanlifemanage.createbeanexcannotation;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description 通过注解的方式声明bean创建的时候运行的方法
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.createbeanexcannotation
 */
public class SingerAnnotation {

    public static final String DEFAULT_NAME="Tony SH";

    private String name;

    private int age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @PostConstruct
    public void init() throws Exception{
        System.out.println("Initinal bean by annotation");
        if(name == null){
            System.out.println("name 属性使用默认值");
            this.name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("age 属性必须赋值，不能为空" + SingerAnnotation.class);
        }
    }

    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static SingerAnnotation getBean(String name, ApplicationContext applicationContext){
        try{
            SingerAnnotation singerAnnotation = (SingerAnnotation) applicationContext.getBean(name);
            System.out.println(singerAnnotation);
            return singerAnnotation;
        }catch (BeanCreationException e){
            System.out.println("配置bean的时候抛出异常" + e.getMessage());
            return null;
        }
    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                 = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-createbean-annotation.xml");
        genericXmlApplicationContext.refresh();

        getBean("singerOne",genericXmlApplicationContext);
        getBean("singerTwo",genericXmlApplicationContext);
        getBean("singerThree",genericXmlApplicationContext);

        genericXmlApplicationContext.close();
    }

}
