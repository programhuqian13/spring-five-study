package org.tony.springframework.study.inter;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.inter
 */
public interface MessageRenderer {

    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();

}
