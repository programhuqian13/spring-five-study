package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.AlbumService;
import org.tony.springframework.study.services.SingerService;
import org.tony.springframework.study.services.impl.SingerServiceImpl;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/27
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class SpringDataJpaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testFindAll() {
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> singers = singerService.findAll();
        if (singers != null && singers.size() > 0) {
            singers.stream().forEach(singer -> LOGGER.info(singer.toString()));
        }
    }

    @Test
    public void testFindByFirstName() {
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> singers = singerService.findByFirstName("John");
        if (singers != null && singers.size() > 0) {
            singers.stream().forEach(singer -> LOGGER.info(singer.toString()));
        }
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> singers = singerService.findByFirstNameAndLastName("John", "Butler");
        if (singers != null && singers.size() > 0) {
            singers.stream().forEach(singer -> LOGGER.info(singer.toString()));
        }
    }

    @Test
    public void testFindByTile(){
        AlbumService albumService = genericApplicationContext.getBean("albumService", AlbumService.class);
        List<Album> albums = albumService.findByTitle("The");
        if(albums != null && albums.size() > 0){
            albums.stream().forEach(album -> LOGGER.info(album.toString()));
        }
    }

    @Test
    public void testFindBySinger(){
        AlbumService albumService = genericApplicationContext.getBean("albumService", AlbumService.class);
        Singer singer = new Singer();
        singer.setId(1L);
        List<Album> albums = albumService.findBySinger(singer);
        if(albums != null && albums.size() > 0){
            albums.stream().forEach(album -> LOGGER.info(album.toString()));
        }
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
