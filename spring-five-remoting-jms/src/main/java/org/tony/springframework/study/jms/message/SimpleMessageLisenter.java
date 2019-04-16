package org.tony.springframework.study.jms.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.jms.message
 */
@Component("simpleMessageLisenter")
public class SimpleMessageLisenter {

    private static final Logger logger = LoggerFactory.getLogger(SimpleMessageLisenter.class);

    @JmsListener(destination = "tony5", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.info(">>> Received: " + textMessage.getText());
            System.out.println(">>> Received: " + textMessage.getText());
        } catch (JMSException e) {
            logger.error("JMS error",e);
        }
    }
}
