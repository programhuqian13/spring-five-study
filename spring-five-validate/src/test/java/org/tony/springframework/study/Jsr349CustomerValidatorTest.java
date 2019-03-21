package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.validator.Genre;
import org.tony.springframework.study.validator.JSR349AppConfig;
import org.tony.springframework.study.validator.customervalidate.Singer;
import org.tony.springframework.study.validator.customervalidate.SingerCusValidattionService;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class Jsr349CustomerValidatorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Jsr349CustomerValidatorTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext =
                new AnnotationConfigApplicationContext(JSR349AppConfig.class);
    }

    @Test
    public void testCustomerValidator(){
        SingerCusValidattionService singerValidattionService =
                genericApplicationContext.getBean(SingerCusValidattionService.class);
        Singer singer = new Singer();
        singer.setFirstName("huqian");
        singer.setLastName("tony");
        singer.setGender(null);
        singer.setGenre(Genre.COUNTRY);

        validateSinger(singer, singerValidattionService);
    }

    private void validateSinger(Singer singer, SingerCusValidattionService singerValidattionService) {
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
