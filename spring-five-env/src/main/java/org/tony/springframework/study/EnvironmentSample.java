package org.tony.springframework.study;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class EnvironmentSample {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.refresh();
        ConfigurableEnvironment environment =
                genericXmlApplicationContext.getEnvironment();
        MutablePropertySources mutablePropertySources
                = environment.getPropertySources();

        Map<String,Object> appMap = new HashMap<>();
        appMap.put("user.home","application_home");

        mutablePropertySources.addLast(
                new MapPropertySource("prospring5_MAP",appMap)
        );

        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("JAVA_HOME:" + System.getenv("JAVA_HOME"));
        System.out.println("user.home: " + environment.getProperty("user.home"));
        System.out.println("JAVA_HOME: " + environment.getProperty("JAVA_HOME"));

        genericXmlApplicationContext.close();

    }

}
