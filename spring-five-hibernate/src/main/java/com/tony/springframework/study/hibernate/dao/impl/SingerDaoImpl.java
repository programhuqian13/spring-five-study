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
 * @see org.hibernate.SessionFactory
 * @see org.hibernate.Session
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
        //sessionFactory.getCurrentSession()获取当前的会话
        //createQuery会将sql转换为HQL进行查询
        //from Singer s：等价于select s from Singer s
        //sessionFactory创建一个session进行操作数据库操作
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().createNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        //setParameter设置参数 getNamedQuery:得到查询的语句
        return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById")
                .setParameter("id",id).uniqueResult();
    }


    @Override
    public Singer save(Singer contact) {
        //添加或者修改
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        return contact;
    }

    @Override
    public void delete(Singer contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }
}
