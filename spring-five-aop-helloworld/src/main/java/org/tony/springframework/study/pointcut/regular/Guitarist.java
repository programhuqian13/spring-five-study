package org.tony.springframework.study.pointcut.regular;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.regularpointcut
 */
public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("just keep me where the light is");
    }

    @Override
    public void sing1() {
        System.out.println("just keep me where the light is");
    }

    @Override
    public void rest() {
        System.out.println("zzz");
    }

    @Override
    public void talk() {
        System.out.println("talk");
    }
}
