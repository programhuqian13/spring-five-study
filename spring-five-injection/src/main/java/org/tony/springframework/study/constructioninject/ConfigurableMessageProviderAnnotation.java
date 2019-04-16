package org.tony.springframework.study.constructioninject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.tony.springframework.study.jms.message.MessageProvider;

/**
 * @Description 已注解的方式
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject
 */
@Service("messageProvider")
public class ConfigurableMessageProviderAnnotation implements MessageProvider{

    private String message;

    //进行自动注解并进行值的赋值
    @Autowired
    public ConfigurableMessageProviderAnnotation(
            @Value("this is constrable inject message") String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
