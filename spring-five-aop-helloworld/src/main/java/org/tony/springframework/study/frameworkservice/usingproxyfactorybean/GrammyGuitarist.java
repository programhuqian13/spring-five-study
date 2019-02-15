package org.tony.springframework.study.frameworkservice.usingproxyfactorybean;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybean
 */
public class GrammyGuitarist {
    public void sing() {
        System.out.println("你把我灌醉...");
    }

    public void sing(Guitar guitar) {
        System.out.println(guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
