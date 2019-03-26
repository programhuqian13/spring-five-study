package org.tony.springframework.study.jpamodelgen;

import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Instrument;
import org.tony.springframework.study.entity.Singer;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.jpamodelgen
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Singer.class)
public abstract class Singer_ {

    public static volatile SingularAttribute<Singer, String> firstName;
    public static volatile SingularAttribute<Singer, String> lastName;
    public static volatile SetAttribute<Singer, Album> albums;
    public static volatile SetAttribute<Singer, Instrument> instruments;
    public static volatile SingularAttribute<Singer, Long> id;
    public static volatile SingularAttribute<Singer, Integer> version;
    public static volatile SingularAttribute<Singer, Date> birthDate;
}
