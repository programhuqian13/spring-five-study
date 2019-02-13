package org.tony.springframework.study.pointcut.bymethodname;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.pointcutbymethodname
 */
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Gravity is working against me\n" +
                "And graviity wants to bring me down");
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
