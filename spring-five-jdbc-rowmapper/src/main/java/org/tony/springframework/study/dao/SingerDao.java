package org.tony.springframework.study.dao;

import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    String findFirstNameById(Long id);

    void insert(Singer singer);

    void delete(Long id);

    void update(Singer singer);
}
