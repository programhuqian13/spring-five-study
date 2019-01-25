package org.tony.springframework.applicationevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.applicationevent
 */
public class Publisher implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(String message){
        applicationContext.publishEvent(new MessageEvent(this,message));
    }

    public static void main(String ... args){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("classpath:spring/app-publisherevent-context.xml");
        Publisher publisher = (Publisher) applicationContext.getBean("publisher");
        publisher.publish("I send an sos to the world....");
        publisher.publish(".......I hope that someone gets my ....");
        publisher.publish("... Message in a bottle");
    }
}
