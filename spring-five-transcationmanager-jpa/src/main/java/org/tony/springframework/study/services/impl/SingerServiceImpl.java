package org.tony.springframework.study.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.dao.SingerRepsitory;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepsitory singerRepsitory;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepsitory.findAll());
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer fingById(Long id) {
        return singerRepsitory.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepsitory.save(singer);
    }

    @Override
    public void delete(Singer singer) {

    }

    @Transactional(readOnly = true)
    @Override
    public Long countAll() {
        return singerRepsitory.countAllSingers();
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public Long countAllPropagation() {
        return singerRepsitory.countAllSingers();
    }
}
