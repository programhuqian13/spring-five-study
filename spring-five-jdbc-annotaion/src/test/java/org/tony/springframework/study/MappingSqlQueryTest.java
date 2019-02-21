package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.config.ModelJdbcOperationsConfig;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.util.Date;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class MappingSqlQueryTest {

    public static Logger logger = LoggerFactory.getLogger(MappingSqlQueryTest.class);

    private SingerDao singerDao;

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void setBeforeTest() {
        this.genericApplicationContext
                = new AnnotationConfigApplicationContext(ModelJdbcOperationsConfig.class);

        this.singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
    }

    @Test
    public void findAllTest() {

        List<Singer> singers = singerDao.findAll();

        singers.stream().forEach(singer -> logger.info(singer.toString()));
    }

    @Test
    public void findByFirstNameTest(){
        List<Singer> singers = singerDao.findByFirstName("o");
        singers.stream().forEach(singer -> logger.info(singer.toString()));
    }

    @Test
    public void updateTest(){
        Singer singer = new Singer();
        singer.setId(2L);
        singer.setBrithDate(new Date());
        singer.setLastName("bbbb");
        singer.setFirstName("aaaa");
        singerDao.update(singer);
    }

    @After
    public void testAfter(){
        genericApplicationContext.close();
    }

}
