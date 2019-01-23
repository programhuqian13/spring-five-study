package org.tony.springframework.study.relovingdependency;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description 解决依赖的问题，当一个bean依赖另一个bean的话就需要进行将依赖的bean先初始化
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.relovingdependency
 */
public class Singer implements ApplicationContextAware{

    ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Guitar guitar;

    public Singer(){}

    public void sing(){
        guitar = applicationContext.getBean("guitar",Guitar.class);
        guitar.sing();
    }
}
