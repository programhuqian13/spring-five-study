package com.tony.springframework.study.helloworld;

import com.tony.springframework.study.message.HelloWorldMessageProvider;
import com.tony.springframework.study.message.MessageProvider;
import com.tony.springframework.study.message.MessageRenderer;
import com.tony.springframework.study.message.StandarOutMessageRenderer;

/**
 * @Description 以接口的方式进行扩展 打印hello world
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.helloworld
 */
public class HelloWorldMessage {

    public static void main(String ... args){
        MessageRenderer messageRenderer = new StandarOutMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }

}
