package com.tony.springframework.study.factory;

import com.tony.springframework.study.message.MessageProvider;
import com.tony.springframework.study.message.MessageRenderer;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description 从属性文件中加载接口的方式，根据不同的配置进行加载不同的接口实现
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.factory
 */
public class MessageFacroty {

    private static MessageFacroty instance;

    private Properties properties;
    private MessageProvider messageProvider;
    private MessageRenderer messageRenderer;

    public MessageFacroty(){
        properties = new Properties();

        try{
            //加载属性文件及其属性文件中的属性
            properties.load(this.getClass().getResourceAsStream("/message-factory.properties"));
            String rendererClassName = properties.getProperty("renderer.class");
            String providerClassName = properties.getProperty("prodiver.class");
            //利用Class.forName进行实例化相关的接口实现类
            messageProvider = (MessageProvider) Class.forName(providerClassName).newInstance();
            messageRenderer = (MessageRenderer) Class.forName(rendererClassName).newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageFacroty();
    }

    public static MessageFacroty getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return this.messageRenderer;
    }

    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }

}
