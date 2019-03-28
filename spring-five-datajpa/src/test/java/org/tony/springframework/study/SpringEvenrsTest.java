package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.entity.SingerAuditEvents;
import org.tony.springframework.study.services.SingerAuditEnversService;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description 监控数据的版本号
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class SpringEvenrsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringEvenrsTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void setUp() {
        genericApplicationContext
                = new AnnotationConfigApplicationContext(EventsConfig.class);
    }

    @Test
    public void testFindAll() {
        SingerAuditEnversService singerAuditEnversService
                = genericApplicationContext.getBean("singerAuditEnversService", SingerAuditEnversService.class);
        List<SingerAuditEvents> result = singerAuditEnversService.findAll();
        listResult(result);
    }

    @Test
    public void testInsert() {
        SingerAuditEnversService singerAuditEnversService
                = genericApplicationContext.getBean("singerAuditEnversService", SingerAuditEnversService.class);
        SingerAuditEvents singerAuditEvents = new SingerAuditEvents();
        singerAuditEvents.setFirstName("SH");
        singerAuditEvents.setLastName("devj");
        singerAuditEvents.setBirthDate(new Date((new GregorianCalendar(1992, 5, 11)).getTime().getTime()));
        //添加
        singerAuditEnversService.save(singerAuditEvents);
        listResult(singerAuditEnversService.findAll());
        //修改
        singerAuditEvents.setLastName(".netj");
        singerAuditEnversService.save(singerAuditEvents);

        SingerAuditEvents historySinger = singerAuditEnversService.findAuditByRevision(1L, 1);
        LOGGER.info("history version 1: {}", historySinger.toString());

        historySinger = singerAuditEnversService.findAuditByRevision(1L, 2);
        LOGGER.info("history version 2: {}", historySinger.toString());


    }

    private void listResult(List<SingerAuditEvents> result) {
        if (result != null && result.size() > 0) {
            result.stream().forEach(singerAuditEvents -> LOGGER.info(singerAuditEvents.toString()));
        }
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
