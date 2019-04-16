package org.tony.springframework.study.jms.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.jms.message
 */
@Component("simpleMessageSender")
public class SimpleMessageSender implements MessageSender{

    private static final Logger logger = LoggerFactory.getLogger(SimpleMessageSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(String message) {
        jmsTemplate.setDeliveryDelay(5000L);
        this.jmsTemplate.send(new MessageCreator() {
            //创建一个新的TextMessage实例，发送消息到消息队列中
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                logger.info(">>> sending: " + textMessage.getText());
                System.out.println(">>> sending: " + textMessage.getText());
                return textMessage;
            }
        });
    }

}
