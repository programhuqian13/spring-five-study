package org.tony.springframework.beanlifemanage.createbeanexcmethod;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 创建bean的时候执行一个方法
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.createbeanexcmethod
 */
public class Singer {

    private static final String DEFAULT_NAME = "Tony Hu";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    //bean初始化的时候调用这个方法
    public void init(){
        System.out.println("Initialzing bean");
        if(name == null){
            System.out.println("使用默认的值");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException(
                    "age 属性必须设置" + Singer.class
            );
        }
    }

    public String toString(){
        return "\tName:" + name + "\n\tAge: " + age;
    }

    public static Singer getBean(String beanName, ApplicationContext applicationContext){
        try{
            Singer singer = (Singer) applicationContext.getBean(beanName);
            System.out.println(singer);
            return singer;
        }catch (BeanCreationException e){
            System.out.println("配置bean的时候发生错误" + e.getMessage());
            return null;
        }
    }

    public static void main(String ... args){

        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-createbean-callmethod.xml");
        genericXmlApplicationContext.refresh();

        getBean("singerOne",genericXmlApplicationContext);
        getBean("singerTwo",genericXmlApplicationContext);
        getBean("singerThree",genericXmlApplicationContext);

        genericXmlApplicationContext.close();
    }

}
