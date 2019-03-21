package org.tony.springframework.study.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study.validator")
public class JSR349AppConfig {

    //验证器被注入(注意与spring提供的验证器接口的不同，
    // 后者是org.springframework. Validator .Validator .Validator)。
    // 一旦定义了LocalValidatorFactoryBean，
    // 您就可以在应用程序的任何地方为Validator接口创建句柄
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
