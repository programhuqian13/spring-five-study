package org.tony.springframework.study.inter.impl;

import org.tony.springframework.study.inter.MessageProvider;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Description 使用jsr330注解 需要添加javax.inject的依赖
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.inter.impl
 */
@Named("messageProvider") //需要添加javax.inject的依赖
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default Message!";

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
