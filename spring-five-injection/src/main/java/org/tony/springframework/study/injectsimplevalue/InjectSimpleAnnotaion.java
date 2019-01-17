package org.tony.springframework.study.injectsimplevalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description 进行注解的方式进行加载
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectsimplevalue
 */
@Component("injectSimple")
public class InjectSimpleAnnotaion {

    @Value("tony")
    private String name;

    @Value("27")
    private int age;

    @Value("1.82")
    private float height;

    @Value("false")
    private boolean programmer;

    @Value("12346765223")
    private Long ageInSeconds;

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
