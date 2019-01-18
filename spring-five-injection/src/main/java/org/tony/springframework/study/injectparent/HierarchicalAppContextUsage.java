package org.tony.springframework.study.injectparent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/18
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectparent
 */
public class HierarchicalAppContextUsage {

    public static void main(String ... args){
//        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
//        parent.load("classpath:spring/app-parent-context.xml");
//        parent.refresh();
        ApplicationContext parent = new ClassPathXmlApplicationContext("spring/app-parent-context.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/app-child-context.xml"},parent);

//        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
//        parent.load("classpath:spring/app-child-context.xml");
//        //设置父的applicationcontext 并加载父applicationContext中的bean
//        child.setParent(parent);
//        child.refresh();

        Song song1 = (Song) context.getBean("song1");
        Song song2 = (Song) context.getBean("song2");
        Song song3 = (Song) context.getBean("song3");

        System.out.println("from parent ctx1：" + song1.getTitle());
        System.out.println("from child ctx2: " + song2.getTitle());
        System.out.println("from parent ctx3：" + song3.getTitle());

//        child.close();
//        parent.close();
    }

}
