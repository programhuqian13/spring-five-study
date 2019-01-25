package org.tony.springframework.applicationevent;

import org.springframework.context.ApplicationListener;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.applicationevent
 */
public class MessageEventListener implements ApplicationListener<MessageEvent>{


    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent msgEvt = messageEvent;
        System.out.println("Receive: " + msgEvt.getMessage());
    }
}
