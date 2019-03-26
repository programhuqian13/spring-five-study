package org.tony.springframework.study.services;

import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 操作数据接口
 * @Version 1.0
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerService {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    List<Singer> findAllByNativeQuery();

    List<Singer> findByCriteriaQuery(String firstName,String lastName);



}
