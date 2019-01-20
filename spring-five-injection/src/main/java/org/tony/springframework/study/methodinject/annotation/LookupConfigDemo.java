package org.tony.springframework.study.methodinject.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by tony on 2019/1/20.
 */
public class LookupConfigDemo {

    @Configuration
    @ComponentScan("org.tony.springframework.study.methodinject.annotation")
    public static class LookupConfig{}

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext = new AnnotationConfigApplicationContext(LookupConfig.class);

        DemoBean demoBean = genericApplicationContext.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean demoBean1 = genericApplicationContext.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo("abstractLookupDemoBean",demoBean);
        displayInfo("standardLookupDemoBean",demoBean1);

        genericApplicationContext.close();
    }

    public static void displayInfo(String beanName,DemoBean bean) {
        Singer singer = bean.getMySinger();
        Singer singer1 = bean.getMySinger();

        System.out.println("" + beanName + ": Singer Instances the same?" + (singer == singer1));
        //stopwatch:简单的秒表，允许计时的一些任务，公开总运行时间和运行时间为每个命名的任务。
        // 隐藏System.currentTimeMillis()的使用，提高应用程序代码的可读性，减少计算错误的可能性。
        // 请注意，此对象不是设计为线程安全的，也不使用同步。
        // 此类通常用于在概念验证和开发过程中验证性能，而不是作为生产应用程序的一部分
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100000; x++) {
            Singer singer2 = bean.getMySinger();
            singer2.sing();
        }
        stopWatch.stop();
        System.out.println("1000000 gets took " + stopWatch.getTotalTimeMillis() + "ms");
    }

}
