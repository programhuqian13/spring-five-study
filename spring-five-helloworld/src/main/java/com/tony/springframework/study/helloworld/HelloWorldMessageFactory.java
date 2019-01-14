package com.tony.springframework.study.helloworld;

import com.tony.springframework.study.factory.MessageFacroty;
import com.tony.springframework.study.message.MessageProvider;
import com.tony.springframework.study.message.MessageRenderer;

/**
 * @Description 利用工程方法进行加载相关的接口实现类
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.helloworld
 */
public class HelloWorldMessageFactory {

    public static void main(String ... args){
        MessageRenderer messageRenderer = MessageFacroty.getInstance().getMessageRenderer();
        MessageProvider messageProvider = MessageFacroty.getInstance().getMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }

}
