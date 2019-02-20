package org.tony.springframework.study;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.config.ResultSetExtractorConfig;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class ResultSetExtractorTest {

    public static Logger logger = LoggerFactory.getLogger(ResultSetExtractorTest.class);

    @Test
    public void findAllWithAlbumsTest() {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(ResultSetExtractorConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");
        List<Singer> singers = singerDao.findAllWithAlbums();
        singers.stream().forEach(singer -> logger.info(singer.toString()));
        genericApplicationContext.close();
    }

    @Test
    public void findAllTest(){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(ResultSetExtractorConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");

        List<Singer> singers = singerDao.findAll();

        singers.stream().forEach(singer -> logger.info(singer.toString()));
        genericApplicationContext.close();
    }

    @Test
    public void findAllAlbumTest(){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(ResultSetExtractorConfig.class);
        SingerDao singerDao = (SingerDao) genericApplicationContext.getBean("singerDao");

        List<Album> albums = singerDao.findAllAlbum();
        albums.stream().forEach(album -> logger.info(album.toString()));

        genericApplicationContext.close();
    }

}
