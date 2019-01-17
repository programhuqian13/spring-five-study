package org.tony.springframework.study.injectvaluespel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectvaluespel
 */
@Service("injectSimpleSpELAnnotation")
public class InjectSimpleSpELAnnotation {

    @Value("#{injectSimpleAnnotationConfig.name}")
    private String name;

    @Value("#{injectSimpleAnnotationConfig.age}")
    private int age;

    @Value("#{injectSimpleAnnotationConfig.height}")
    private float height;

    @Value("#{injectSimpleAnnotationConfig.programmer}")
    private boolean programmer;

    @Value("#{injectSimpleAnnotationConfig.ageInSeconds}")
    private Long ageInSeconds;

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
