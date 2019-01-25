package org.tony.springframework.usebeannameawareinterface;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.usebeannameawareinterface
 */
public class NamedSinger implements BeanNameAware{

    private String name;

    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing(){
        System.out.println("Singer" + name + " - sing()");
    }
}
