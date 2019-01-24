package org.tony.springframework.beanlifemanage.createbeanexcinterface;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description
 * @see org.springframework.beans.factory.InitializingBean
 * InitializingBean
 * 在Spring中定义的InitializingBean接口允许您在bean代码中定义希望bean
 * 接收Spring完成配置的通知的代码。
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.createbeanexcinterface
 */
public class SingerInterface implements InitializingBean{

    private static final String DEFAULT_NAME="Tony SH";

    private String name;

    private int age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }


    /***
     * afterPropertiesSet这个方法和init初始化方法一样
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initinal bean by interface");
        if(name == null){
            System.out.println("使用默认的值");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException(
                    "age 属性不能为空" + SingerInterface.class
            );
        }
    }

    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }

    public static SingerInterface getBean(String name, ApplicationContext applicationContext){
        try{
            SingerInterface singerInterface = (SingerInterface) applicationContext.getBean(name);
            System.out.println(singerInterface);
            return singerInterface;
        }catch (BeanCreationException e){
            System.out.println("创建bean发生错误" + e.getMessage());
            return null;
        }

    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-createbean-interface.xml");
        genericXmlApplicationContext.refresh();
        getBean("singerOne",genericXmlApplicationContext);
        getBean("singerTwo",genericXmlApplicationContext);
        getBean("singerThree",genericXmlApplicationContext);
        genericXmlApplicationContext.close();
    }
}
