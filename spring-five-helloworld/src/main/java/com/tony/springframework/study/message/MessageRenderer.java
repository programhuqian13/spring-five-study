package com.tony.springframework.study.message;

/**
 * @Description 进行消息的render和MessageProvider设置与获取
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.message
 */
public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();

}
