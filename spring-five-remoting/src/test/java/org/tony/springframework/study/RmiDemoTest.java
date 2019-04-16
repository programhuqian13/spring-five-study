package org.tony.springframework.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName PACKAGE_NAME
 */
@ContextConfiguration(classes=RmiClientConfig.class)
@RunWith(SpringRunner.class)
public class RmiDemoTest {

    private static final Logger logger = LoggerFactory.getLogger(RmiDemoTest.class);

    @Autowired
    private SingerService singerService;

    @Test
    public void testRmiAll() {
        List<Singer> singers = singerService.findAll();
//        assertEquals(3, singers.size());
        listSingers(singers);
    }
    @Test
    public void testRmiJohn() {
        List<Singer> singers = singerService.findByFirstName("John");
//        assertEquals(2, singers.size());
        listSingers(singers);
    }
    private void listSingers(List<Singer> singers){
        singers.forEach(s -> logger.info(s.toString()));
    }

}
