package org.tony.springframework.study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.AlbumRepository;
import org.tony.springframework.study.services.AlbumService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/27
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Album> findBySinger(Singer singer) {
        return albumRepository.findBySinger(singer);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }
}
