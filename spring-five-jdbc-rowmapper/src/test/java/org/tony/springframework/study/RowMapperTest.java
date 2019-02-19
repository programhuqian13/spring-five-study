package org.tony.springframework.study;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.config.RowMapperConfig;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class RowMapperTest {

    public static Logger logger = LoggerFactory.getLogger(RowMapperTest.class);

    @Test
    public void findAllTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(RowMapperConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
        List<Singer> singers = singerDao.findAll();

        singers.stream().forEach(singer -> logger.info(singer.toString()));

        genericApplicationContext.close();

    }

    //其他的方法和以前的实例一样

}
