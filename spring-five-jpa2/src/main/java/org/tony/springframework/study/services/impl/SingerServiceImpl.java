package org.tony.springframework.study.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.services.SingerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 * @see javax.persistence.EntityManager
 * @see javax.persistence.TypedQuery
 *
 */
@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    static final String ALL_STRING_NATIVE_QUERY =
            "select id,first_name,last_name,brith_date,version from singer";

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerService.class);

    /***
     * 这是实体管理器注入的标准JPA注释。
     * 对于为什么要使用名称@PersistenceContext来注入实体管理器，
     * 这可能存在疑问，但是如果您认为持久性上下文本身是由EntityManager管理的，
     * 那么注释命名就非常有意义了。如果应用程序中有多个持久性单元，
     * 还可以向注释添加unitName属性，以指定要注入哪个持久性单元
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
//        throw new NotImplementedException();
        LOGGER.info("-----查询所有的singer数据-----");
        //<T> TypedQuery<T> createNamedQuery(String var1, Class<T> var2);
        return entityManager.createNamedQuery(Singer.FIND_ALL,Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        throw new NotImplementedException();
//        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
        throw new NotImplementedException();
//        return null;
    }

    @Override
    public Singer save(Singer singer) {
        throw new NotImplementedException();
//        return null;
    }

    @Override
    public void delete(Singer singer) {
        throw new NotImplementedException();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        throw new NotImplementedException();
//        return null;
    }
}
