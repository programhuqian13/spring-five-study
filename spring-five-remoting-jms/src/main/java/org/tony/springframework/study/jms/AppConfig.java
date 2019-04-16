package org.tony.springframework.study.jms;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.core.remoting.impl.netty.TransportConstants;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;
import org.hornetq.jms.client.HornetQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@EnableJms
@ComponentScan(basePackages = "org.tony.springframework.study.jms")
public class AppConfig {

    @Bean
    public HornetQQueue tony5(){
        return new HornetQQueue("tony5");
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        Map<String,Object> conDetail = new HashMap<>();
        conDetail.put(TransportConstants.HOST_PROP_NAME,"127.0.0.1");
        conDetail.put(TransportConstants.PORT_PROP_NAME,"5445");
        TransportConfiguration configuration =
                new TransportConfiguration(NettyConnectorFactory.class.getName(),conDetail);
        return new HornetQJMSConnectionFactory(false,configuration);
    }

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer>
            jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("3-5");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(tony5());
        return jmsTemplate;
    }

}
