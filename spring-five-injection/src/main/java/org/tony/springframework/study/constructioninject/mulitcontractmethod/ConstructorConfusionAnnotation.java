package org.tony.springframework.study.constructioninject.mulitcontractmethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description 通过注解的方式
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject.mulitcontractmethod
 */
@Service("constructorConfusion")
public class ConstructorConfusionAnnotation {

    private String someValue;

    public ConstructorConfusionAnnotation(String someValue){
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    /***
     * 进行Autowired注解的时候，只能用在一个构造函数中，不能同时使用
     * @param someValue
     */
    @Autowired
    public ConstructorConfusionAnnotation(@Value("90") Integer someValue){
        System.out.println("ConstructorConfusion(Integer) called");
        this.someValue = Integer.toString(someValue);
    }

    public String toString(){
        return someValue;
    }

}
