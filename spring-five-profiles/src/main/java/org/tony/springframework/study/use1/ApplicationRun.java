package org.tony.springframework.study.use1;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.use1
 */
public class ApplicationRun {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-*-context.xml");
        genericXmlApplicationContext.refresh();

        FoodProviderService foodProviderService =
                genericXmlApplicationContext.getBean("foodProviderService",FoodProviderService.class);
        List<Food> list = foodProviderService.providerLunchSet();
        list.stream().forEach(food -> {
            System.out.println("Food: " + food.getName());
        });

        genericXmlApplicationContext.close();

    }

}
