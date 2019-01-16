package com.tony.springframework.study.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description 使用java进行配置相关的bean，这里需要使用@Configuration的注解
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study
 */
@Configuration
//导入相关的配置文件，这里可以是多个，用逗号分隔
@ImportResource(locations = "classpath:spring/app-annotation-import-config.xml")
public class HelloWorldSpringConfigImport {

}
