package org.tony.springframework.study.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.tony.springframework.study.entity.Singer;
import org.tony.springframework.study.jpamodelgen.Singer_;
import org.tony.springframework.study.services.SingerService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 * @see javax.persistence.EntityManager
 * @see javax.persistence.TypedQuery
 */
@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

    static final String ALL_STRING_NATIVE_QUERY =
            "select id,first_name,last_name,birth_date,version from singer";

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
        return entityManager.createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
//        throw new NotImplementedException();
        LOGGER.info("-----查询所有的singer数据,进行lazy加载-----");
        List<Singer> singers = entityManager.createNamedQuery(Singer.Find_ALL_WITH_ALBUM, Singer.class).getResultList();
        return singers;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(Long id) {
//        throw new NotImplementedException();
        TypedQuery<Singer> query = entityManager.createNamedQuery(Singer.FIND_BY_ID, Singer.class);
        query.setParameter("id", id);  //设置相关的属性
        return query.getSingleResult();  //返回单一对象
    }

    @Override
    public Singer save(Singer singer) {
//        throw new NotImplementedException();
        if (singer.getId() == null) {
            LOGGER.info("------添加相关数据----");
            entityManager.persist(singer);
        } else {
            LOGGER.info("-------修改相关数据-----");
            entityManager.merge(singer);
        }
        return singer;
    }

    @Override
    public void delete(Singer singer) {
//        throw new NotImplementedException();
        Singer singer1 = entityManager.merge(singer);
        entityManager.remove(singer1);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
//        throw new NotImplementedException();
        LOGGER.info("-----进行原生数据库查询----");
//        return entityManager.createNativeQuery(ALL_STRING_NATIVE_QUERY,Singer.class).getResultList();
        //使用@SqlResultSetMapping注解的使用
        return entityManager.createNativeQuery(ALL_STRING_NATIVE_QUERY, "singerResult").getResultList();
    }

    /***
     * 根据姓和名查询singer
     * 使用JPA2的Criteria Api
     * @param firstName
     * @param lastName
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        LOGGER.info("find singer by firstName:{} and lastName:{}", firstName, lastName);
        //创建一个criteriaBuilder实例：entityManager.getCriteriaBuilder();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //创建一个查询语句：criteriaBuilder.createQuery(Singer.class)
        CriteriaQuery<Singer> criteriaQuery = criteriaBuilder.createQuery(Singer.class);
        //调用CriteriaQuery.from()方法，传入实体类。结果是一个查询根对象(根<Singer>接口)对应于指定的实体。
        // 查询根对象构成查询中的路径表达式的基础
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        //进行关联查询
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);

        criteriaQuery.select(singerRoot).distinct(true);
        //predicate实例是通过调用criteriabuier . connection()方法获得的，
        // 这意味着要使用一个或多个限制的连接。predicate可以是简单predicate，
        // 也可以是复合predicate，谓词是指示表达式定义的选择条件的约束
        Predicate predicate = criteriaBuilder.conjunction();

        if (!StringUtils.isEmpty(firstName)) {
            Predicate preFirstName = criteriaBuilder.equal(singerRoot.get(Singer_.firstName), firstName);
            predicate = criteriaBuilder.and(predicate, preFirstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            Predicate preLastName = criteriaBuilder.equal(singerRoot.get(Singer_.lastName), lastName);
            predicate = criteriaBuilder.and(predicate, preLastName);
        }
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
