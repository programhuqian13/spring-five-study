package com.tony.springframeworld.study.config;

import com.tony.springframeworld.study.message.HelloWorldMessageProvider;
import com.tony.springframeworld.study.message.MessageProvider;
import com.tony.springframeworld.study.message.MessageRenderer;
import com.tony.springframeworld.study.message.StanderOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 这样的配置类使用@Configuration进行注释，
 * 并包含使用@Bean进行注释的方法，这些方法由Spring IoC容器直接调用以实例化bean。
 * bean的名称将与用于创建它的方法的名称相同
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
