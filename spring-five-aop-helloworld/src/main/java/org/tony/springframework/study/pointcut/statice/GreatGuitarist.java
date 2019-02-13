package org.tony.springframework.study.pointcut.statice;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.staticpointcut.demo1
 * @see Singer
 */
public class GreatGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n" +
                "But I did not shoot the deputy");
    }
}
