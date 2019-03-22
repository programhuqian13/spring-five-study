package com.tony.springframework.study.hibernate;

import com.tony.springframework.study.hibernate.dao.SingerDao;
import com.tony.springframework.study.hibernate.entity.Album;
import com.tony.springframework.study.hibernate.entity.Instrument;
import com.tony.springframework.study.hibernate.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/19
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate
 */
public class SpringHibernateDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String... args) {
//        GenericApplicationContext genericApplicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring-hibernate.xml");
        genericXmlApplicationContext.refresh();
        SingerDao singerDao = genericXmlApplicationContext.getBean(SingerDao.class);
        //根据编号查询singer数据
        Singer singer = singerDao.findById(2L);
        System.out.println("singer findById: " + singer.toString());
        //删除singer
        singerDao.delete(singer);
        //查询所有的singer数据
//        listSinger(singerDao.findAll());
        //添加singer数据
        Singer insertSinger = new Singer();
        insertSinger.setLastName("aaaaaaa");
        insertSinger.setFirstName("bbbbbbb");
        insertSinger.setVersion(0);
        insertSinger.setBirthDate(new Date());
        singerDao.save(insertSinger);
        //进行数据的懒加载，加载关联的表数据
        listSingersWithAlbum(singerDao.findAllWithAlbum());
        genericXmlApplicationContext.close();
    }

    //进行数据的懒加载
    private static void listSingersWithAlbum(List<Singer> allWithAlbum) {

        for (Singer singer : allWithAlbum) {
            System.out.println(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println(album.toString());
                }
            }

            if (singer.getInstruments() != null) {
                if (singer.getInstruments() != null) {
                    for (Instrument instrument : singer.getInstruments()) {
                        System.out.println(instrument.toString());
                    }
                }
            }
        }

    }

    private static void listSinger(List<Singer> all) {
        LOGGER.info("------LIST singers:");
        for (Singer singer : all) {
            System.out.println(singer.toString());
        }

    }

}
