package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig{
        //定义别名使用name
        @Bean(name = {"singer","tony","ssss"})
        public Singer singer(){
            return new Singer();
        }
    }

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext =
                new AnnotationConfigApplicationContext(AliasBeanConfig.class);

        Map<String,Singer> beans = genericApplicationContext.getBeansOfType(Singer.class);

        beans.entrySet().stream().forEach(b ->{
            System.out.println("id: " + b.getKey()
            + " \n aliases: " + Arrays.toString(
                    genericApplicationContext.getAliases(b.getKey())
            ) + "\n");
        });
    }

}
