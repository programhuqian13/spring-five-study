package org.tony.springframework.study.services.impl;

import com.google.common.collect.Lists;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tony.springframework.study.entity.SingerAuditEvents;
import org.tony.springframework.study.services.SingerAuditEnversRepository;
import org.tony.springframework.study.services.SingerAuditEnversService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("singerAuditEnversService")
@Transactional
public class SingerAuditEnversServiceImpl implements SingerAuditEnversService {


    @Autowired
    private SingerAuditEnversRepository singerAuditEnversRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<SingerAuditEvents> findAll() {
        return Lists.newArrayList(singerAuditEnversRepository.findAll());
    }

    @Override
    public SingerAuditEvents fingById(Long id) {
        return singerAuditEnversRepository.findById(id).get();
    }

    @Override
    public SingerAuditEvents save(SingerAuditEvents singerAuditEvents) {
        return singerAuditEnversRepository.save(singerAuditEvents);
    }

    @Transactional(readOnly = true)
    @Override
    public SingerAuditEvents findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        //auditReader.find返回一个entity的版本信息
        return auditReader.find(SingerAuditEvents.class, id, revision);
    }
}
