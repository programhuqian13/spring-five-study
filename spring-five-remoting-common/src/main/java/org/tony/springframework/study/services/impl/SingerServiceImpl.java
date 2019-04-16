package org.tony.springframework.study.services.impl;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerServiceImpl.class);

    @Autowired
    private SingerDao singerDao;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerDao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findByFirstName(String firstName) {
        return singerDao.findByFirstName(firstName);
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        return singerDao.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerDao.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        singerDao.delete(singer);
    }
}
