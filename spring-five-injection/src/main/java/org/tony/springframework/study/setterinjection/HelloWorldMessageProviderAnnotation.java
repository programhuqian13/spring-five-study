package org.tony.springframework.study.setterinjection;

import org.springframework.stereotype.Service;
import org.tony.springframework.study.jms.message.MessageProvider;

/**
 * @Description 通过注解的方式加载bean
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection.message
 */
@Service("messageProvider")
public class HelloWorldMessageProviderAnnotation implements MessageProvider {

    @Override
    public String getMessage() {

        return "Hello world";
    }
}
