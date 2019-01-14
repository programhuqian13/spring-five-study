package com.tony.springframeworld.study.config;

import com.tony.springframeworld.study.message.HelloWorldMessageProvider;
import com.tony.springframeworld.study.message.MessageProvider;
import com.tony.springframeworld.study.message.MessageRenderer;
import com.tony.springframeworld.study.message.StanderOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframeworld.study.helloworld
 */
@Configuration
public class HelloWorldConfig {

    //相当于 <bean id="messageProvider" class="com.tony.springframework.study.message.HelloWorldMessageProvider" />
    @Bean
    public MessageProvider messageProvider(){
        return new HelloWorldMessageProvider();
    }

    //相当于 <bean id="messageRenderer" class="com.tony.springframework.study.message.StandarOutMessageRenderer">
    //          <property name="messageProvider" ref="messageProvider"/>
    //       </bean>
    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StanderOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

}
