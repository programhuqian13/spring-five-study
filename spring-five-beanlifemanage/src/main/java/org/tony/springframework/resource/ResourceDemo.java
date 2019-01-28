package org.tony.springframework.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.resource
 */
public class ResourceDemo {

    public static void main(String ... args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test","txt");
        file.deleteOnExit();

        Resource res = applicationContext.getResource("file://" + file.getPath());
        displayInfo(res);
        Resource resource = applicationContext.getResource("classpath:test.txt");
        displayInfo(resource);
        Resource resource1 = applicationContext.getResource("http://www.baidu.com");
        displayInfo(resource1);
    }

    public static void displayInfo(Resource resource) throws IOException {
        System.out.println(resource.getClass());
        System.out.println(resource.getURL().getContent());
        System.out.println("");
    }

}
