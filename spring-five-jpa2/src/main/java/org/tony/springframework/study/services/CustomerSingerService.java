package org.tony.springframework.study.services;

import org.tony.springframework.study.entity.CustomerSinger;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface CustomerSingerService {

    List<CustomerSinger> findAll();

}
