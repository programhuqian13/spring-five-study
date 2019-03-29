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

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class TxJtaTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(TxJtaTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void setUp() {
        genericApplicationContext
                = new AnnotationConfigApplicationContext(ServiceConfig.class, XAJpaConfig.class);
    }

    @Test
    public void testInsert() {
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
        singerService.save(singer);
        if (singer.getId() != null) {
            LOGGER.info("--> Singer saved successfully");
        } else {
            LOGGER.info("--> Singer was not saved, check the configuration!!");
        }
    }

    @Test
    public void testFindAll(){
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        List<Singer> singers = singerService.findAll();
        if (singers.size()!= 2) {
            LOGGER.error("--> Something went wrong.");
        } else {
            LOGGER.info("--> Singers form both DBs: " + singers);
        }
    }


    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
