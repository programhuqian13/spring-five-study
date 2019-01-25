package org.tony.springframework.applicationevent;

import org.springframework.context.ApplicationEvent;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.applicationevent
 */
public class MessageEvent extends ApplicationEvent{

    public String msg;

    public MessageEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage(){
        return this.msg;
    }
}
