package org.tony.springframework.study.constructioninject.mulitcontractmethod;

/**
 * @Description 多个构造函数进行注入不同的类型
 * 当有多个构造函数进行注入的时候，参数的类型不一致会调用string的这个方法
 * 我们需要注入的时候制定相应的类型
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject.mulitcontractmethod
 */
public class ConstructorConfusion {

    private String someValue;

    public ConstructorConfusion(String someValue){
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(Integer someValue){
        System.out.println("ConstructorConfusion(Integer) called");
        this.someValue = Integer.toString(someValue);
    }

    public String toString(){
        return someValue;
    }

}
