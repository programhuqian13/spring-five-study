package org.tony.springframework.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.jms.AppConfig;
import org.tony.springframework.study.jms.message.MessageSender;

import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class JMSDemoTest {

    public static void main(String... args) throws IOException {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender =
                genericApplicationContext.getBean("simpleMessageSender",MessageSender.class);
        for(int i = 0; i < 10; i++){
            messageSender.sendMessage("Test Message: " + i);
        }

        System.in.read();
        genericApplicationContext.close();
    }

}
