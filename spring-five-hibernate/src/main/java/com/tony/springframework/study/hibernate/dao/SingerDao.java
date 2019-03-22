package com.tony.springframework.study.hibernate.dao;

import com.tony.springframework.study.hibernate.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/19
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate.dao
 */
public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer contact);

    void delete(Singer contact);

}
