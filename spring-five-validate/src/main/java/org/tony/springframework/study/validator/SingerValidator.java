package org.tony.springframework.study.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tony.springframework.study.entity.Singer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
@Component("singerValidator")
public class SingerValidator implements Validator {

    //指示验证器是否支持传入类类型的验证
    @Override
    public boolean supports(Class<?> aClass) {
        return Singer.class.equals(aClass);
    }

    //对传入的对象执行验证
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
    }
}
