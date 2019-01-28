package org.tony.springframework.study.mixedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.mixedconfig
 */
@Configuration
@ImportResource(value = "classpath:spring/app-mixedconfig-context.xml")
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
