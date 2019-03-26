package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.CustomerSinger;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.CustomerSingerService;
import org.tony.springframework.study.services.SingerService;
import org.tony.springframework.study.services.impl.SingerSummaryUntypeImpl;
import sun.util.calendar.Gregorian;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class JpaOptionalTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JpaOptionalTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testFindAll() {
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> singers = singerService.findAll();
        singers.stream().forEach(singer -> LOGGER.info(singer.toString()));
    }

    @Test
    public void testFindAllWithAblum() {
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> singers = singerService.findAllWithAlbum();
        singers.stream().forEach(singer -> {
            LOGGER.info(singer.toString());
            if (singer.getAlbums() != null && singer.getAlbums().size() > 0){
                singer.getAlbums().stream().forEach(album -> {
                    LOGGER.info(album.toString());
                });
            }

            if (singer.getInstruments() != null && singer.getInstruments().size() > 0){
                singer.getInstruments().stream().forEach(instrument -> {
                    LOGGER.info(instrument.toString());
                });
            }
        });
    }

    @Test
    public void testFindById(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        Singer singer = singerService.findById(3L);
        LOGGER.info(singer.toString());
    }

    //修改处理的resultSet值
    @Test
    public void testDisplayAllSingerSummary(){
        SingerSummaryUntypeImpl singerSummaryUntype =
                genericApplicationContext.getBean("singerSummaryUntypeImpl", SingerSummaryUntypeImpl.class);
        singerSummaryUntype.displayAllSingerSummary();
    }

    @Test
    public void testDelete(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        Singer singer = singerService.findById(4L);
        singerService.delete(singer);
    }

    @Test
    public void testCustomerSingerServiceImplFindAll(){
        CustomerSingerService customerSingerService
                = genericApplicationContext.getBean("customerSingerServiceImpl", CustomerSingerService.class);
        List<CustomerSinger> result = customerSingerService.findAll();
        if(result != null && result.size() > 0){
            result.stream().forEach(customerSinger -> {
                LOGGER.info(customerSinger.toString());
            });
        }
    }

    @Test
    public void testInsert(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        Singer singer = new Singer();
        singer.setLastName("thisAs");
        singer.setFirstName("shanghai");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1992,5,11)).getTime().getTime()));
        singerService.save(singer);

//        Album album = new Album();
//        album.setTitle("my tis as d");
//        album.setSinger(singer);
//        album.setReleaseDate(new Date((
//                new GregorianCalendar(1962,12,2)).getTime().getTime()));
//        singer.addAlbum(album);
    }

    @Test
    public void testUpdate(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        Singer singer = singerService.findById(1L);
        singer.setFirstName("wushibyde");
        singerService.save(singer);

    }

    @Test
    public void testNativeQuery(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> result = singerService.findAllByNativeQuery();
        if(result != null && result.size() > 0){
            result.stream().forEach(singer -> {
                LOGGER.info(singer.toString());
            });
        }
    }

    @Test
    public void testFindByCriteriaQuery(){
        SingerService singerService = genericApplicationContext.getBean("jpaSingerService", SingerService.class);
        List<Singer> result = singerService.findByCriteriaQuery("shanghai","thisAs");
        if(result != null && result.size() > 1){
            result.stream().forEach(singer -> {
                LOGGER.info(singer.toString());
            });
        }
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
