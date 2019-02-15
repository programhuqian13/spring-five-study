package org.tony.springframework.study.pointcut.composable;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.composable
 */
public interface Singer {

    void sing();

    void sing(Guitar guitar);

    void rest();

    void talk();

}
