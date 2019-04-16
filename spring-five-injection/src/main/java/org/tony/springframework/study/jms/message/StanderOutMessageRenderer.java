package org.tony.springframework.study.jms.message;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.setterinjection.message
 */
public class StanderOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("messageProvider must be exists!");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
