package org.tony.springframework.study.boot.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/16
 * @ProjectName spring-five-study
 * @PackageName PACKAGE_NAME
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.tony.springframework.study.boot.jms")
public class Application {

    private static Logger logger =
            LoggerFactory.getLogger(Application.class);

    @Bean
    public JmsListenerContainerFactory<?>
    containerFactory(ConnectionFactory connectionFactory,
                     DefaultJmsListenerContainerFactoryConfigurer containerFactoryConfigurer) {
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        containerFactoryConfigurer.configure(factory, connectionFactory);
        return factory;
    }

    @JmsListener(destination = "tony5", containerFactory = "containerFactory")
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(">>> reciver message: " + textMessage.getText());
        } catch (JMSException e) {
            logger.error("JMS error", e);
        }
    }

    public static void main(String... args) throws IOException {
        ConfigurableApplicationContext configurableApplicationContext
                = SpringApplication.run(Application.class, args);
        JmsTemplate jmsTemplate = configurableApplicationContext.getBean(JmsTemplate.class);
        jmsTemplate.setDeliveryDelay(5000L);
        for(int i = 0; i < 10; i++){
            System.out.println(">>> send message: " + i);
            jmsTemplate.convertAndSend("tony5","Text Message: " + i);
        }

        System.in.read();

        configurableApplicationContext.close();
    }

}
