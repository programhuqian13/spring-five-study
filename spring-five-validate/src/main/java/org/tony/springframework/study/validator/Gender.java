package org.tony.springframework.study.validator;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
public enum Gender {

    MALE("M"), FEMALE("F");

    private String code;

    Gender(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
