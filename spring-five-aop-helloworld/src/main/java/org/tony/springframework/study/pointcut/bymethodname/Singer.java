package org.tony.springframework.study.pointcut.bymethodname;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.pointcutbymethodname
 */
public interface Singer {

    void sing();

    void sing(Guitar guitar);

    void rest();

    void talk();

}
