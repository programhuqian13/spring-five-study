package org.tony.springframework.study.config4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config4
 */
@Configuration
@ComponentScan("org.tony.springframework.study.config4")
public class AppConfig {

    @Autowired
    private MessageProvider messageProvider;

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;
    }

}
