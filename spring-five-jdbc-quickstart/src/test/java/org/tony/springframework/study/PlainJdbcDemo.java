package org.tony.springframework.study;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.dao.impl.PlainSingerDao;
import org.tony.springframework.study.entity.Singer;

import java.sql.Date;
import java.util.List;


/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class PlainJdbcDemo {

    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    @Test
    public void listSingerTest(){
        List<Singer> singers = singerDao.findAll();
        singers.stream().forEach(singer -> logger.info(singer.toString()));
    }

    @Test
    public void insertSingerTest(){
        long datetime = new java.util.Date().getTime();
        Singer singer = new Singer();
        singer.setId(4L);
        singer.setBrithDate(new Date(datetime));
        singer.setFirstName("Zhang");
        singer.setLastName("Shan");
        singerDao.insert(singer);
    }

    @Test
    public void deleteSingerTest(){
        singerDao.delete(3L);
    }

    @Test
    public void findFirstNameByIdTest(){
        logger.info(singerDao.findFirstNameById(2L));
    }

    @Test
    public void updateSingerTest(){
        Singer singer = new Singer();
        singer.setFirstName("li");
        singer.setLastName("si");
        singer.setId(1L);
        singerDao.update(singer);
    }

    @Test
    public void findByFirstNameTest(){
        List<Singer> result = singerDao.findByFirstName("%a%");
        result.stream().forEach(singer -> logger.info(singer.toString()));
    }

}
