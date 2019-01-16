package com.tony.springframework.study.message;

import org.springframework.stereotype.Component;

/**
 * @Description 默认的打印消息
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.message
 */
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}
