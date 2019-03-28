package org.tony.springframework.study.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.tony.springframework.study.entity.Singer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public interface SingerRepsitory extends CrudRepository<Singer, Long> {

    @Query("select count(s) from Singer s")
    Long countAllSingers();

}
