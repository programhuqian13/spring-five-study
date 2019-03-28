package org.tony.springframework.study.services;

import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/26
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerService {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

}
