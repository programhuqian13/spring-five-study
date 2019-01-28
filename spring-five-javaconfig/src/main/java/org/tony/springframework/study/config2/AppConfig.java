package org.tony.springframework.study.config2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.tony.springframework.study.xml.ConfigurableMessageProvider;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 从属性文件中读取相关的message
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config2
 */
@Configuration
@PropertySource("classpath:message.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(environment.getProperty("message"));
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

}
