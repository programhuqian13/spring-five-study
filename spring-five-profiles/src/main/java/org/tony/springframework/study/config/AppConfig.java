package org.tony.springframework.study.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.tony.springframework.study.use1.Food;
import org.tony.springframework.study.use1.FoodProviderService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@Configuration
@Import(value = {HighSchoolConfig.class,KindergartenConfig.class})
public class AppConfig {

    public static void main(String ... args){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        FoodProviderService foodProviderService =
                applicationContext.getBean("foodProviderService",FoodProviderService.class);
        List<Food> list = foodProviderService.providerLunchSet();
        list.stream().forEach(food -> System.out.println("Food: " + food.getName()));
    }

}
