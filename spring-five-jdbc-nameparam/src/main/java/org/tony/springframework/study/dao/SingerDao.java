package org.tony.springframework.study.dao;

import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 数据操作Dao层接口
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    String findLastNameById(Long id);

    String findFirstNameById(Long Id);

    void insert(Singer singer);

    void update(Singer singer);

    void delete(Long singerId);

    List<Singer> findAllWithDetail();

    void insertWithDetail(Singer singer);

}
