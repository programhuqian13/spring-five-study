package org.tony.springframework.study.services.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Transactional
@Service("singerSummaryUntypeImpl")
@Repository
public class SingerSummaryUntypeImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public void displayAllSingerSummary() {
        //createQuery返回的是一个object List 进行迭代处理
        List result = entityManager.createQuery(
                "select s.firstName, s.lastName, a.title from Singer s "
                        + "left join s.albums a "
                        + "where a.releaseDate=(select max(a2.releaseDate) "
                        + "from Album a2 where a2.singer.id = s.id)")
                .getResultList();
        int count = 0;
        for (Iterator i = result.iterator(); i.hasNext(); ) {
            Object[] values = (Object[]) i.next();
            System.out.println(++count + ": " + values[0] + ", " + values[1] + ", " + values[2]);
        }
    }

}
