package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.tony.springframework.study.converter.MulitConverterConfig;
import org.tony.springframework.study.entity.AnotherSinger;
import org.tony.springframework.study.entity.Singer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 两个任意类型之间的转换
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class MulitConverterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MulitConverterTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext =
                new AnnotationConfigApplicationContext(MulitConverterConfig.class);
    }

    @Test
    public void testMulitConverter() {
        Singer tony = genericApplicationContext.getBean("tony", Singer.class);
        LOGGER.info("tony singer: {}", tony.toString());

        //用于类型转换的服务接口。这是转换系统的入口点。
        // 调用转换(对象、类)来使用此系统执行线程安全类型转换。
        ConversionService conversionService =
                genericApplicationContext.getBean(ConversionService.class);

        AnotherSinger anotherSinger =
                conversionService.convert(tony, AnotherSinger.class);

        LOGGER.info("Another singer: {}", anotherSinger.toString());
        String [] stringArray = conversionService.convert("a,b,c",String[].class);

        LOGGER.info("String array:" + stringArray[0] + stringArray[1] + stringArray[2]);

        List<String> listString = new ArrayList<>();
        listString.add("a");
        listString.add("b");
        listString.add("c");

        Set<String> setString = conversionService.convert(listString, HashSet.class);

        setString.stream().forEach(str -> {
            LOGGER.info("Str:" + str);
        } );
    }


    @After
    public void testAfter() {
        genericApplicationContext.close();
    }
}
