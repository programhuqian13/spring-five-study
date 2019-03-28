package org.tony.springframework.study.services;

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
public interface AlbumService {

    List<Album> findBySinger(Singer singer);

    List<Album> findByTitle(String title);

}
