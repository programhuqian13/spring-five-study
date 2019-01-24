package org.tony.springframework.beanlifemanage.createbeanwithbeanannotation;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/23
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.createbeanwithbeanannotation
 */
public class Singer {

    public static final String DEFAULT_NAME = "Tony SH";

    private String name;

    private int age = Integer.MIN_VALUE;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void init(){
        System.out.println("initinal bean for @Bean annotation");
        if (name == null) {
            System.out.println("使用默认值");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException(
                    "age 参数设置错误或者或者没有设置" + Singer.class
            );
        }
    }

    public String toString(){
        return "\tName: " + name + "\n\tAge: " + age;
    }


}
