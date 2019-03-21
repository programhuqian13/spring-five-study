package org.tony.springframework.study.validator.asserttruevalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
@Component("singerCusAssertValidattionService")
public class SingerCusAssertValidattionService {

    @Autowired
    private Validator validator;

    //要在POJO上执行验证，需要调用Validator.validate()方法。
    // 验证结果将作为constraint违例<T>接口的列表返回
    public Set<ConstraintViolation<Singer>> validateSinger(Singer singer) {
        return validator.validate(singer);
    }

}
