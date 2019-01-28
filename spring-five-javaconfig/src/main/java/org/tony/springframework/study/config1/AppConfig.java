package org.tony.springframework.study.config1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tony.springframework.study.xml.ConfigurableMessageProvider;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
public class AppConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
