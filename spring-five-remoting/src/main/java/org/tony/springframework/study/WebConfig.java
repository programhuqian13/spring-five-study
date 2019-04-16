package org.tony.springframework.study;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 一个配置类实现了WebMvcConfigurer接口。
 * 这个接口是在Spring 3.1中引入的，它定义了回调方法，
 * 以定制使用@EnableWebMvc启用的Spring MVC的基于java的配置。
 * 因为我们只需要公开HTTP服务(不需要web接口)，所以在这种情况下，
 * 一个空的实现就足够了。
 * 使用@EnableWebMvc注释的这个接口的实现替换了使用mvc名称空间的Spring XML配置
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {



}
