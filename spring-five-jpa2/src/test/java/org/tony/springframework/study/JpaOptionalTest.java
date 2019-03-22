package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class JpaOptionalTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JpaOptionalTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore(){
        genericApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testFindAll(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService",SingerService.class);
        List<Singer> singers = singerService.findAll();
        singers.stream().forEach(singer -> LOGGER.info(singer.toString()));
    }

    @After
    public void testAfter(){
        genericApplicationContext.close();
    }

}
