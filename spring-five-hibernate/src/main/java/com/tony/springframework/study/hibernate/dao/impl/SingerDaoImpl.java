package com.tony.springframework.study.hibernate.dao.impl;

import com.tony.springframework.study.hibernate.dao.SingerDao;
import com.tony.springframework.study.hibernate.entity.Singer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/19
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate.dao.impl
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)  //设置事务为只读的事务
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Override
    public Singer findById() {
        return null;
    }

    @Override
    public Singer save(Singer contact) {
        return null;
    }

    @Override
    public void delete(Singer contact) {

    }
}
