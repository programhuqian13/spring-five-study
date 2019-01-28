package org.tony.springframework.study.config5.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.tony.springframework.study.xml.MessageProvider;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config5.message
 */
@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider{

    private String message;

    public ConfigurableMessageProvider(@Value("this is a config 5 annotation value")
                                       String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
