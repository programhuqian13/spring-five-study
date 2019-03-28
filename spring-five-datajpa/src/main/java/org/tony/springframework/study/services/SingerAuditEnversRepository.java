package org.tony.springframework.study.services;

import org.springframework.data.repository.CrudRepository;
import org.tony.springframework.study.entity.SingerAuditEvents;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerAuditEnversRepository extends CrudRepository<SingerAuditEvents,Long> {
}
