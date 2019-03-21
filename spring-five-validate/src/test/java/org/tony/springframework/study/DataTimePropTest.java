package org.tony.springframework.study;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.entity.Singer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class DataTimePropTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataTimePropTest.class);

    private GenericXmlApplicationContext genericApplicationContext;

    @Before
    public void testBefore(){
        genericApplicationContext =
                new GenericXmlApplicationContext();
        genericApplicationContext.load("classpath:spring/prop-edit-app-context.xml");
        genericApplicationContext.refresh();
    }

    @Test
    public void testProp(){
        Singer singer = genericApplicationContext.getBean("tony",Singer.class);
        LOGGER.info("tony: {}",singer.toString());

        Singer singer2 = genericApplicationContext.getBean("propert",Singer.class);
        LOGGER.info("propert: {}",singer2.toString());

    }

    @After
    public void testAfter(){
        genericApplicationContext.close();
    }

}
