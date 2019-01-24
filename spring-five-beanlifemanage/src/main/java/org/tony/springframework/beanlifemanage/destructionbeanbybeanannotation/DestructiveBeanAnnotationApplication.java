package org.tony.springframework.beanlifemanage.destructionbeanbybeanannotation;

import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.destructionbeanbyannotation
 */
public class DestructiveBeanAnnotationApplication {

    @Configuration
    @ComponentScan("org.tony.springframework.beanlifemanage.destructionbeanbybeanannotation")
    public static class DestructiveBeanAnnotationConfig{

        @Lazy
        @Bean(initMethod = "init",destroyMethod = "destory")
        public DestructiveBeanAnnotation destructiveBeanAnnotation(){
            DestructiveBeanAnnotation destructiveBeanAnnotation = new DestructiveBeanAnnotation();
            destructiveBeanAnnotation.setFilePath("C:\\Users\\xuanyi\\AppData\\Local\\Temp\\Test.txt");
            return destructiveBeanAnnotation;
        }
    }

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(DestructiveBeanAnnotationConfig.class);
        DestructiveBeanAnnotation destructiveBeanAnnotation
                = (DestructiveBeanAnnotation) genericApplicationContext.getBean("destructiveBeanAnnotation");
        System.out.println("Calling destory method");
        genericApplicationContext.close();
        System.out.println("Called destory method");
    }


}
