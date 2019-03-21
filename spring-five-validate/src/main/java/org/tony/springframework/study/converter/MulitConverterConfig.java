package org.tony.springframework.study.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.tony.springframework.study.entity.Singer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study.converter")
public class MulitConverterConfig {

    @Bean
    public Singer tony() throws MalformedURLException {
        Singer singer  = new Singer();
        singer.setFirstName("tony");
        singer.setLastName("shagss");
        singer.setPersonalSite(new URL("https://www.baidu.com"));
        singer.setBirthDate(stringToDateTimeConverter().convert("1992-05-11"));
        return singer;
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(stringToDateTimeConverter());
        converters.add(singerToAnotherSingerConverter());
        conversionServiceFactoryBean.setConverters(converters);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    public StringToDateTimeConverter stringToDateTimeConverter(){
        return new StringToDateTimeConverter();
    }

    @Bean
    public SingerToAnotherSingerConverter singerToAnotherSingerConverter(){
        return new SingerToAnotherSingerConverter();
    }

}
