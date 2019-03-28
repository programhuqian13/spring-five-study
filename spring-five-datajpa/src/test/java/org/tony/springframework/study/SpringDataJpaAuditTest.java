package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.entity.SingerAudit;
import org.tony.springframework.study.services.SingerAuditService;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class SpringDataJpaAuditTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaAuditTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext = new AnnotationConfigApplicationContext(AppAuditConfig.class);
    }

    @Test
    public void testFindAll(){
        SingerAuditService singerAuditService =
                genericApplicationContext.getBean("singerAuditService",SingerAuditService.class);
        List<SingerAudit> singers = singerAuditService.findAll();
        listSinger(singers);
    }

    @Test
    public void testInsert(){
        SingerAuditService singerAuditService =
                genericApplicationContext.getBean("singerAuditService",SingerAuditService.class);
        SingerAudit singerAudit = new SingerAudit();
        singerAudit.setFirstName("BB");
        singerAudit.setLastName("HHUIJ");
        singerAudit.setBirthDate(
                new Date((new GregorianCalendar(1992,5,11)).getTime().getTime()));
        singerAuditService.save(singerAudit);

        List<SingerAudit> singers = singerAuditService.findAll();
        listSinger(singers);
    }

    private void listSinger(List<SingerAudit> singers){
        if(singers != null && singers.size() > 0){
            singers.stream().forEach(singerAudit -> LOGGER.info(singerAudit.toString()));
        }
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
