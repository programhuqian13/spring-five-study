package org.tony.springframework.study.pointcut.statice;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.staticpointcut.demo1
 * @see Singer
 */
public class GoodGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Who says I canot be free \n" +
                "From all id the things that I used to be");
    }
}
