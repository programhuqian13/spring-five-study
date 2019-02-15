package org.tony.springframework.study.frameworkservice.aspectjstyleannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.aspectjstyleannotation
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study.frameworkservice.aspectjstyleannotation")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
