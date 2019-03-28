package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class TxDeclarativeTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(TxAnnotationTest.class);

    private GenericXmlApplicationContext genericApplicationContext;

    @Before
    public void setUp() {
        genericApplicationContext = new GenericXmlApplicationContext();
        genericApplicationContext.load("classpath:app-aop-transcationmanager.xml");
        genericApplicationContext.refresh();
    }

    @Test
    public void testFindAll() {
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        List<Singer> result = singerService.findAll();
        if (result != null && result.size() > 0) {
            result.stream().forEach(singer -> LOGGER.info(singer.toString()));
        }
    }

    @Test
    public void testSingerService() {
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        Singer singer = new Singer();
        singer.setFirstName("ccc");
        singer.setLastName("SHS");

        Album album = new Album();
        album.setTitle("aaaa");
        album.setSinger(singer);
        singerService.save(singer);
        List<Singer> result = singerService.findAll();
        if (result != null && result.size() > 0) {
            result.stream().forEach(singerr -> LOGGER.info(singerr.toString()));
        }
        singer = singerService.fingById(1L);
        singer.setFirstName("BB");
        singer.setLastName("SaaHS");
        singerService.save(singer);
        LOGGER.info("singer is save success,Singer:{}", singer.toString());
    }

    @Test
    public void testCountAll() {
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        Long count = singerService.countAll();
        LOGGER.info("singer count all:{}", count);
    }

    @Test
    public void testCountAllP(){
        SingerService singerService = genericApplicationContext.getBean("singerService", SingerService.class);
        Long count = singerService.countAllPropagation();
        LOGGER.info("singer count all:{}", count);
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
