package org.tony.springframework.study.injectvaluespel;


import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectvaluespel
 */
@Component("injectSimpleAnnotationConfig")
public class InjectSimpleAnnotationConfig {

    private String name = "tony";
    private int age = 27;
    private float height = 1.82F;
    private boolean programmer = false;
    private Long ageInSeconds = 1234564332L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimpleConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
