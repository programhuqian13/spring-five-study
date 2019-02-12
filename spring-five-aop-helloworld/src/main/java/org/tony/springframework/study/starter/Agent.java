package org.tony.springframework.study.starter;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class Agent {

    //此处为AOP的连接点 joinpoint
    public void speak() {
        System.out.println("Bond");
    }

}
