package org.tony.springframework.study.services.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.ex.AsyncXAResourcesException;
import org.tony.springframework.study.services.SingerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("singerService")
@Transactional
@Repository
public class SingerServiceImpl implements SingerService {

    public static final String FIND_ALL = "select s from Singer s";

    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;

    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
//        throw new NotImplementedException();
        List<Singer> resultA = findAllInA();

        List<Singer> resultB = findAllInB();

        if(resultA.size() != resultB.size()){
            throw new AsyncXAResourcesException("XA resources do not contain the same expected data.");
        }
        Singer singerA = resultA.get(0);
        Singer singerB = resultB.get(0);
        if(!singerA.getFirstName().equals(singerB.getFirstName())){
            throw new AsyncXAResourcesException("XA resources do not contain the same expected data.");
        }
        List<Singer> singerFromBoth = new ArrayList<>();
        singerFromBoth.add(singerA);
        singerFromBoth.add(singerB);
        return singerFromBoth;
    }

    private List<Singer> findAllInB() {
        return emB.createQuery(FIND_ALL).getResultList();
    }

    private List<Singer> findAllInA() {
        return emA.createQuery(FIND_ALL).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        throw new NotImplementedException();
//        return null;
    }

    @Override
    public Singer save(Singer singer) {
        Singer singerB = new Singer();
        singerB.setFirstName("CC");
        singerB.setLastName("CCCC");
        if(singer.getId() != null){
            emA.persist(singer);
            emB.persist(singerB);
            //throw new JpaSystemException(new PersistenceException());
        }else{
            emA.merge(singer);
            emB.merge(singer);
        }
        return singer;
    }

    @Override
    public long countAll() {
        return 0;
    }
}
