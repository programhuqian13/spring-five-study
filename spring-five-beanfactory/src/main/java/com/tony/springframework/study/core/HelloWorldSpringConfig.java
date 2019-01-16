package com.tony.springframework.study.core;

import com.tony.springframework.study.message.HelloWorldMessageProvider;
import com.tony.springframework.study.message.MessageProvider;
import com.tony.springframework.study.message.MessageRenderer;
import com.tony.springframework.study.message.StandarOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 使用java进行配置相关的bean，这里需要使用@Configuration的注解
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study
 */
@Configuration
public class HelloWorldSpringConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandarOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

}
