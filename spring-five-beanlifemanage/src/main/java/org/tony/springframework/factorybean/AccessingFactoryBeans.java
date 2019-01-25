package org.tony.springframework.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * @Description 直接访问FactoryBean
 * FactoryBean的目的是作为支持基础结构的一部分使用，
 * 以允许您在IoC设置中使用更多的应用程序类。
 * 避免直接访问FactoryBean并手动调用它的getObject()，
 * 让Spring为您做这件事;如果您手动这样做，
 * 您将为自己做额外的工作，
 * 并且不必要地将应用程序与将来很容易更改的特定实现细节耦合起来。
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybean
 */
public class AccessingFactoryBeans {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-factorybean-context.xml");
        genericXmlApplicationContext.refresh();

        genericXmlApplicationContext.getBean("shaDigest", MessageDigest.class);

        MessageDigestFactoryBean messageDigestFactoryBean =
                (MessageDigestFactoryBean) genericXmlApplicationContext.getBean("&shaDigest");

        try{
            MessageDigest shaDigest = messageDigestFactoryBean.getObject();
            System.out.println(shaDigest.digest("Hello world!".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        genericXmlApplicationContext.close();
    }

}
