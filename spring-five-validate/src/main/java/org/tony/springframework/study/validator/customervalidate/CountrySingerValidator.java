package org.tony.springframework.study.validator.customervalidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator.customervalidate
 */
public class CountrySingerValidator implements ConstraintValidator<CheckSingerCountry,Singer> {
    @Override
    public boolean isValid(Singer singer, ConstraintValidatorContext context) {
        boolean result = true;
        if(singer.getGenre() != null && (singer.isCountrySinger() && (singer.getLastName() == null || singer.getGender() == null))){
            result = false;
        }
        return result;
    }

    @Override
    public void initialize(CheckSingerCountry constraintAnnotation) {

    }
}
