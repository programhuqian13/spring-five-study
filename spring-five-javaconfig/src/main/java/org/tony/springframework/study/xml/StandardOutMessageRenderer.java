package org.tony.springframework.study.xml;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.xml
 */
public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    public StandardOutMessageRenderer(){
        System.out.println("--> StandardOutMessageRenderer构造函数被调用");
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("messageProvider属性必须要提供在："
            + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("--> StandardOutMessageRenderer设置messageProvider");
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
