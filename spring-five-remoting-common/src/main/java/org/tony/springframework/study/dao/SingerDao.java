package org.tony.springframework.study.dao;

import org.springframework.data.repository.CrudRepository;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public interface SingerDao extends CrudRepository<Singer, Long> {

    List<String> findByFirstName(String firstName);

}
