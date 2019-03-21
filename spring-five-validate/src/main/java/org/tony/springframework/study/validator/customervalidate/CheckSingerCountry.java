package org.tony.springframework.study.validator.customervalidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator.customervalidate
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  //注释应该只应用于类级别
@Constraint(validatedBy = CountrySingerValidator.class) //指示它是一个验证器，validatedBy属性指定提供验证逻辑的类
@Documented
public @interface CheckSingerCountry {

    String message() default "Country Singer should have gender and last name defined";

    //groups属性指定验证组。可以将验证器分配给不同的组，并在特定的组上执行验证。
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
