package org.tony.springframework.study.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/27
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findBySinger(Singer singer);

    //自定义查询语句使用Query注解
    //@Param其实可以不需要，但是当参数名和查询参数不一致的情况下这个注解告诉spring匹配的相关参数
    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTitle(@Param("title") String title);

}
