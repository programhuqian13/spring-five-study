package com.tony.springframework.study.hibernate;

import com.tony.springframework.study.hibernate.dao.SingerDao;
import com.tony.springframework.study.hibernate.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Author xuanyi@baofu.com
 * @Date 2019/3/19
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate
 */
public class SpringHibernateDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = genericApplicationContext.getBean(SingerDao.class);
        listSinger(singerDao.findAll());
        genericApplicationContext.close();
    }

    private static void listSinger(List<Singer> all) {

        LOGGER.info("------LIST singers:");
        all.stream().forEach(singer -> singer.toString());

    }

}
