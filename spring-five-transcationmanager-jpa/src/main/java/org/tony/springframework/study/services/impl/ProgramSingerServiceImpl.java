package org.tony.springframework.study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.tony.springframework.study.dao.SingerRepsitory;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("programSingerService")
public class ProgramSingerServiceImpl implements SingerService{

    @Autowired
    private SingerRepsitory singerRepsitory;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Singer fingById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Singer singer) {

    }

    @Override
    public Long countAll() {
        return transactionTemplate.execute(transactionStatus ->
            entityManager.createNamedQuery(Singer.COUNT_ALL,Long.class).getSingleResult()
        );
    }

    @Override
    public Long countAllPropagation() {
        return null;
    }
}
