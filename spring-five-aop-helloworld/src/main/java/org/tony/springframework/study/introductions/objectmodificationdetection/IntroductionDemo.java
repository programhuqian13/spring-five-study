package org.tony.springframework.study.introductions.objectmodificationdetection;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.introductions.objectmodificationdetection
 */
public class IntroductionDemo {

    public static void main(String... args) {
        Contacts contacts = new Contacts();
        contacts.setName("Tony");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(contacts);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setOptimize(true);

        Contacts proxy = (Contacts) proxyFactory.getProxy();

        IsModified proxyInterface = (IsModified) proxy;

        System.out.println("Is contact?: " + (proxy instanceof Contacts));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Tony");

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        proxy.setName("Qian Hu");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }

}
