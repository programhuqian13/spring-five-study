package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.services.SingerService;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class TxProgrammaticTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(TxAnnotationTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void setUp() {
        genericApplicationContext = new AnnotationConfigApplicationContext(ProgramTransactionManagerConfig.class, DataJpaConfig.class);
    }

    @Test
    public void testCountAll() {
        SingerService singerService = genericApplicationContext.getBean("programSingerService", SingerService.class);
        Long count = singerService.countAll();
        LOGGER.info("singer count all:{}", count);
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
