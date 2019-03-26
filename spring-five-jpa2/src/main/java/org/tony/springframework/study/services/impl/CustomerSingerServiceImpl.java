package org.tony.springframework.study.services.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.entity.CustomerSinger;
import org.tony.springframework.study.services.CustomerSingerService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("customerSingerServiceImpl")
@Repository
@Transactional
public class CustomerSingerServiceImpl implements CustomerSingerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<CustomerSinger> findAll() {
        //新建一个CustomerSinger对象进行查询的时候
        List<CustomerSinger> result = entityManager.createQuery(
                "select new org.tony.springframework.study.entity.CustomerSinger("
                        + "s.firstName, s.lastName, a.title) from Singer s "
                        + "left join s.albums a "
                        + "where a.releaseDate=(select max(a2.releaseDate) "
                        + "from Album a2 where a2.singer.id = s.id)",
                CustomerSinger.class).getResultList();
        return result;
    }
}
