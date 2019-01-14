package com.tony.springframeworld.study.message;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframeworld.study.message
 */
public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();
}
