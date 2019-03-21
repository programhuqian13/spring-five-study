package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.validator.JSR349AppConfig;
import org.tony.springframework.study.validator.Singer;
import org.tony.springframework.study.validator.SingerValidattionService;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class Jsr349AppConfigTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Jsr349AppConfigTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext =
                new AnnotationConfigApplicationContext(JSR349AppConfig.class);
    }

    @Test
    public void testJsr349() {
        SingerValidattionService singerValidattionService =
                genericApplicationContext.getBean(SingerValidattionService.class);
        Singer singer = new Singer();
        singer.setFirstName("J");
        singer.setLastName("tony");
        singer.setGender(null);
        singer.setGenre(null);

        validateSinger(singer, singerValidattionService);
    }

    private void validateSinger(Singer singer, SingerValidattionService singerValidattionService) {
        Set<ConstraintViolation<Singer>> violations =
                singerValidattionService.validateSinger(singer);
        listViolation(violations);
    }

    private void listViolation(Set<ConstraintViolation<Singer>> violations) {

        LOGGER.info("No of validator:{}", violations.size());
        violations.stream().forEach(e -> {
            LOGGER.info("Validator error for property: {}, with value: {}, " +
                            "with error message: {}",
                    e.getPropertyPath(), e.getInvalidValue(), e.getMessage());
        });

    }


    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
