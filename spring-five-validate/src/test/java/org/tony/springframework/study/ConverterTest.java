package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.converter.AppConfig;
import org.tony.springframework.study.entity.Singer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class ConverterTest {

    private GenericApplicationContext genericApplicationContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterTest.class);

    @Before
    public void testBefore(){
        genericApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testConverter(){
        Singer singer = genericApplicationContext.getBean("tony",Singer.class);
        LOGGER.info("tony: {}" , singer.toString());
    }

    @After
    public void testAfter(){
        genericApplicationContext.close();
    }

}
