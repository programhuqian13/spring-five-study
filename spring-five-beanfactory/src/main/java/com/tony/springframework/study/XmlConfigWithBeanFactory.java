package com.tony.springframework.study;

import com.tony.springframework.study.beanfactory.interfaces.Oracle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description 通过beanFactory实例化
 * @Version 1.0
 * @Date 2019/1/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.core
 */
public class XmlConfigWithBeanFactory {

    public static void main(String ... args){
        //DefaultListableBeanFactory 是spring提供的两个主要的BeanFactory的实现之一，并且使用XmlBeanDefinitionReader从XML文件中读取BeanDefinition的信息
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource(
                "spring/xml-bean-factory-config.xml"
        ));
        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }

}
