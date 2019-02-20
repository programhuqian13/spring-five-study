package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
@Repository("singerDao")
public class PlainSingerDao implements SingerDao, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            logger.error("create databaseSource is error in singerDao!");
            throw new BeanCreationException("create databaseSource is error in singerDao!");
        }
    }

    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return null;
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
