package org.tony.springframework.study.injectsimplevalue;

/**
 * @Description 注入简单的值
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
public class InjectSimple {

    private String name;

    private int age;

    private float height;

    private boolean programmer;

    private Long ageInSeconds;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public void setProgrammer(boolean programmer){
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds){
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
