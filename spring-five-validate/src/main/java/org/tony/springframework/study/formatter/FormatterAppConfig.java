package org.tony.springframework.study.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tony.springframework.study.entity.Singer;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Locale;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study.formatter")
public class FormatterAppConfig {

    @Autowired
    private ApplicationConversionServiceFactoryBean conversionService;

    @Bean
    public Singer tony() throws MalformedURLException, ParseException {
        Singer singer = new Singer();
        singer.setFirstName("tony");
        singer.setLastName("asdas");
        singer.setPersonalSite(new URL("https://www.baidu.com"));
        singer.setBirthDate(conversionService.getDateTimeFormatter().parse("1992-05-11", Locale.ENGLISH));
        return singer;
    }

}
