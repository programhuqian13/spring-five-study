package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.formatter.FormatterAppConfig;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class FormatterAppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormatterAppTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext = new AnnotationConfigApplicationContext(FormatterAppConfig.class);
    }

    @Test
    public void testFormatterApp() {
        Singer singer = genericApplicationContext.getBean("tony", Singer.class);
        LOGGER.info("singer:{}", singer.toString());

        ConversionService conversionService =
                genericApplicationContext.getBean("conversionService",ConversionService.class);

        LOGGER.info("Brithday of singer is :" + conversionService.convert(singer.getBirthDate(),String.class));

    }


    @After
    public void testAfter() {
        genericApplicationContext.close();
    }
}
