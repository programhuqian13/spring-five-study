package org.tony.springframework.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.tony.springframework.study.services.SingerService;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
public class HttpInvokerConfig {

    @Autowired
    private SingerService singerService;

    /***
     * httpinvokerserviceexports bean是用httpinvokerserviceexports类定义的，
     * 该类用于通过HTTP调用程序将任何Spring bean作为服务导出。在bean中定义了两个属性
     * @return
     */
    @Bean(name = "/httpInvoker/singerService")
    public HttpInvokerServiceExporter httpInvokerServiceExporter(){
        HttpInvokerServiceExporter httpInvokerServiceExporter
                = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(singerService);
        httpInvokerServiceExporter.setServiceInterface(SingerService.class);
        return httpInvokerServiceExporter;
    }
}
