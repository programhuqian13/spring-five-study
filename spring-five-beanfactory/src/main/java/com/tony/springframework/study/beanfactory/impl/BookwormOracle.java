package com.tony.springframework.study.beanfactory.impl;

import com.tony.springframework.study.beanfactory.Encyclopedia;
import com.tony.springframework.study.beanfactory.interfaces.Oracle;

/**
 * @Description 实现相关的接口
 * @Version 1.0
 * @Date 2019/1/14
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.beanfactory.impl
 */
public class BookwormOracle implements Oracle{

    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia){
        this.encyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedia are a waste of money - go see the world instead";
    }
}
