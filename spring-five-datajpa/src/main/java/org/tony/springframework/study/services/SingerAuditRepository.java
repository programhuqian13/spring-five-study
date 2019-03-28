package org.tony.springframework.study.services;

import org.springframework.data.repository.CrudRepository;
import org.tony.springframework.study.entity.SingerAudit;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/27
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
