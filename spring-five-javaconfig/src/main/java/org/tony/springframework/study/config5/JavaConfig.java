package org.tony.springframework.study.config5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.tony.springframework.study.xml.MessageProvider;
import org.tony.springframework.study.xml.MessageRenderer;
import org.tony.springframework.study.xml.StandardOutMessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config5
 */
@Configuration
@Import(AppConfig.class)  //导入相关的配置文件 将不同的配置类导入进来
public class JavaConfig {

    @Autowired
    private MessageProvider messageProvider;

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;
    }

}
