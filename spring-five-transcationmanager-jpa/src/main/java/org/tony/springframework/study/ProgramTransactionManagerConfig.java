package org.tony.springframework.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study")
public class ProgramTransactionManagerConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public TransactionTemplate transactionTemplate(){
        TransactionTemplate tt = new TransactionTemplate();
        tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_NEVER);
        tt.setTimeout(30);
        tt.setTransactionManager(transactionManager());
        return tt;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
