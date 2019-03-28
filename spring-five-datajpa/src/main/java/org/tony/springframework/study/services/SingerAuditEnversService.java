package org.tony.springframework.study.services;

import org.tony.springframework.study.entity.SingerAuditEvents;

import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface SingerAuditEnversService {

    List<SingerAuditEvents> findAll();

    SingerAuditEvents fingById(Long id);

    SingerAuditEvents save(SingerAuditEvents singerAuditEvents);

    SingerAuditEvents findAuditByRevision(Long id, int revision);

}
