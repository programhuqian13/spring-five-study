package org.tony.springframework.study.services;

import org.tony.springframework.study.entity.SingerAudit;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/27
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerAuditService {

    List<SingerAudit> findAll();

    SingerAudit findById(Long id);

    SingerAudit save(SingerAudit singer);

}
