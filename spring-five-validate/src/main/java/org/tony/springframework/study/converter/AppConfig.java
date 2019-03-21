package org.tony.springframework.study.converter;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.tony.springframework.study.entity.Singer;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
@PropertySource("classpath:prop-edit-app-prop.properties")
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study.converter")
public class AppConfig {

    @Value("${data.format.pattern}")
    private String datePattern;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Singer tony(@Value("${countrySinger.firstName}") String firstName,
                       @Value("${countrySinger.lastName}") String lastName,
                       @Value("${countrySinger.personalSite}") URL personalSite,
                       @Value("${countrySinger.birthDate}") DateTime birthDate){
        Singer singer = new Singer();
        singer.setFirstName(firstName);
        singer.setLastName(lastName);
        singer.setBirthDate(birthDate);
        singer.setPersonalSite(personalSite);
        return singer;
    }


    //这里的bean的方法不要用conversionServiceFactoryBean,而是用conversionService，这样才能注册这个bean
    //通过使用类ConversionServiceFactoryBean声明一个conversionService bean，
    // 我们指示Spring使用类型转换系统。如果没有定义转换服务bean, Spring将使用基于propertyeditor的系统。
    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(stringToDateTimeConverter());
        conversionServiceFactoryBean.setConverters(converters);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    public StringToDateTimeConverter stringToDateTimeConverter(){
        StringToDateTimeConverter stringToDateTimeConverter = new StringToDateTimeConverter();
        stringToDateTimeConverter.setDatePattern(datePattern);
        stringToDateTimeConverter.init();
        return stringToDateTimeConverter;
    }

}
