package org.tony.springframework.study.constructioninject;

import org.tony.springframework.study.message.MessageProvider;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject
 */
public class ConfigurableMessageProvider implements MessageProvider{

    private String message;

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
