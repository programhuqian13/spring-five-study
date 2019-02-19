package org.tony.springframework.study;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.config.NamedParamJdbcConfig;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.util.Date;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class NamedParamJdbcTemplateTest {

    private static Logger logger = LoggerFactory.getLogger(NamedParamJdbcTemplateTest.class);

    @Test
    public void findAllTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
        List<Singer> singers = singerDao.findAll();
        singers.stream().forEach(singer -> logger.info(singer.toString()));

        genericApplicationContext.close();
    }

    @Test
    public void findByFirstNameTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
        List<Singer> singers = singerDao.findByFirstName("a");

        singers.stream().forEach(singer -> logger.info(singer.toString()));

        genericApplicationContext.close();
    }

    @Test
    public void findLastNameByIdTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");

        String result = singerDao.findLastNameById(1L);

        logger.info("findLastNameById result is {}", result);

        genericApplicationContext.close();
    }

    @Test
    public void insertTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");

        Singer singer = new Singer();
        singer.setId(4L);
        singer.setLastName("Smitha");
        singer.setFirstName("Johna");
        singer.setBrithDate(new java.sql.Date(new Date().getTime()));
        singerDao.insert(singer);

        genericApplicationContext.close();
    }

    @Test
    public void deleteTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
        singerDao.delete(4L);
        genericApplicationContext.close();
    }

    @Test
    public void updateTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(NamedParamJdbcConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");

        Singer singer = new Singer();
        singer.setId(4L);
        singer.setLastName("Smit");
        singer.setFirstName("Joh");
        singer.setBrithDate(new java.sql.Date(new Date().getTime()));
        singerDao.update(singer);

        genericApplicationContext.close();
    }

}
