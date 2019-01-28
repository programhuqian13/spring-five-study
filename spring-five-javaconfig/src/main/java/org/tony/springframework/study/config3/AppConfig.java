package org.tony.springframework.study.config3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.tony.springframework.study.xml.ConfigurableMessageProvider;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config3
 */
@Configuration
@PropertySource("classpath:message.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean  //申明为一个bean，如果不指定name属性的话，默认为方法名作为bean的name属性
    @Lazy  //进行懒加载：使用到的时候初始化
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean   //声明为一个bean
    @Scope("prototype")  //声明为多例的模式
    @DependsOn("messageProvider")  //证明该bean依赖messageProvider
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

}
