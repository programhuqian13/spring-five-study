package org.tony.springframework.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.tony.springframework.study.config.highschool.FoodProviderServiceImpl;
import org.tony.springframework.study.use1.FoodProviderService;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@Configuration
@Profile("highschool")
public class HighSchoolConfig {

    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }

}
