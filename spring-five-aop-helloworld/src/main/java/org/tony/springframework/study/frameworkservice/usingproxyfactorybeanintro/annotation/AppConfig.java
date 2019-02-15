package org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro.annotation;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro.Contact;
import org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro.IsModifiedAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybeanintro.annotation
 */
@Configuration
public class AppConfig {

    @Bean
    public Contact guitarist(){
        Contact contact = new Contact();
        contact.setName("Tony");
        return contact;
    }

    @Bean
    public Advisor advisor(){
        return new IsModifiedAdvisor();
    }

    @Bean
    public ProxyFactoryBean bean(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(guitarist());
        proxyFactoryBean.addAdvisor(advisor());
        proxyFactoryBean.setProxyTargetClass(true);
        return proxyFactoryBean;
    }



}
