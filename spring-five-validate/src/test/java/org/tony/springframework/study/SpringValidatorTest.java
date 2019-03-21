package org.tony.springframework.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.validator.AppConfig;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class SpringValidatorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringValidatorTest.class);

    private GenericApplicationContext genericApplicationContext;

    @Before
    public void testBefore() {
        genericApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testValidator() {
        Singer singer = new Singer();
        singer.setFirstName(null);
        singer.setLastName("ASDAS");
        Validator singerValidator = genericApplicationContext.getBean("singerValidator", Validator.class);
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(singer, "Tony");
        ValidationUtils.invokeValidator(singerValidator, singer, result);

        List<ObjectError> errors = result.getAllErrors();
        LOGGER.info("No of validation errors: {}", errors.size());
        errors.stream().forEach(e -> LOGGER.info(e.getCode()));
    }

    @After
    public void testAfter() {
        genericApplicationContext.close();
    }

}
