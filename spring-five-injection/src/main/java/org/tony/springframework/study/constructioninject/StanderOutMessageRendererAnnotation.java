package org.tony.springframework.study.constructioninject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tony.springframework.study.jms.message.MessageProvider;
import org.tony.springframework.study.jms.message.MessageRenderer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection.message
 */
@Service("renderer")
public class StanderOutMessageRendererAnnotation implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("messageProvider must be exists!");
        }
        System.out.println(messageProvider.getMessage());
    }

    /***
     * 除了使用当前@Autowired注解，我们还可以使用@Resource注解
     * Resource注解是在JSR-250标准中存在的使用java的注解
     * 不同的是Resource提供name参数为依赖注入
     * Spring还提供了一个@inject注解是在JSR-299中体现的等于Autowired注解
     * @param messageProvider
     */
    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
