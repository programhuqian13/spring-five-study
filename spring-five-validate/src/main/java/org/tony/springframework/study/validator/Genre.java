package org.tony.springframework.study.validator;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
public enum Genre {

    POP("P"),
    JAZZ("J"),
    BLUES("B"),
    COUNTRY("C");

    private String code;

    Genre(String code){
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
