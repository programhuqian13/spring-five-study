package org.tony.springframework.study.dao;

import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public interface SingerDao {

    //连表查询
    List<Singer> findAllWithAlbums();

    List<Singer> findAll();

    List<Album> findAllAlbum();

}
