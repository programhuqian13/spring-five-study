package com.tony.springframework.study.core;

import com.tony.springframework.study.message.HelloWorldMessageProvider;
import com.tony.springframework.study.message.MessageProvider;
import com.tony.springframework.study.message.MessageRenderer;
import com.tony.springframework.study.message.StandarOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Description 使用java进行配置相关的bean，这里需要使用@Configuration的注解
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study
 */
@Configuration
//进行包扫描并忽略相关的配置类HelloWorldSpringConfig.class
@ComponentScan(basePackages = "com.tony.springframework.study")
public class HelloWorldSpringConfigComscan {

}
