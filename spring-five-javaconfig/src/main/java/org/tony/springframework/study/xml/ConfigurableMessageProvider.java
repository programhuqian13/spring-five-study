package org.tony.springframework.study.xml;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.xml
 */
public class ConfigurableMessageProvider implements MessageProvider{

    private String message = "Default message";

    public ConfigurableMessageProvider(){}

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
