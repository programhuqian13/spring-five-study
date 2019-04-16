package org.tony.springframework.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.tony.springframework.study.services.SingerService;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
public class RmiClientConfig {

    @Bean
    public SingerService singerService(){
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean
                = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceInterface(SingerService.class);
        httpInvokerProxyFactoryBean.setServiceUrl(
                "http://localhost:8080/invoker/httpInvoker/singerService"
        );
        httpInvokerProxyFactoryBean.afterPropertiesSet();
        return (SingerService) httpInvokerProxyFactoryBean.getObject();
    }

}
