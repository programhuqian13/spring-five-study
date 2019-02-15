package org.tony.springframework.study.frameworkservice.aspectjstyleannotation;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.aspectjstyleannotation
 */
public class Guitar {

    private String brand = "tony";

    public String play() {
        return "this is a guitar play!";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
