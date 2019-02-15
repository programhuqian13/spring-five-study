package org.tony.springframework.study.pointcut.composable;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.composable
 */
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: 你是我的眼......");
    }

    @Override
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
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
