package org.tony.springframework.study.constructioninject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tony.springframework.study.constructioninject.config.ConstractableConfig;
import org.tony.springframework.study.jms.message.MessageRenderer;

/**
 * @Description 构造函数注入xml配置读取
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.constructioninject
 */
public class ConstrctableAnnotationConfig {

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConstractableConfig.class);
        MessageRenderer renderer = applicationContext.getBean("renderer",MessageRenderer.class);
        renderer.render();

    }

}
