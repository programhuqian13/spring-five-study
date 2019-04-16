package org.tony.springframework.study.jms.message;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection.message
 */
public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();

}
