package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@ComponentScan(basePackages = "org.tony.springframework.study")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.tony.springframework.study"})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class EventsConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsConfig.class);

    @Bean
    public DataSource dataSource(){
        try{
            EmbeddedDatabaseBuilder embeddedDatabaseBuilder
                    = new EmbeddedDatabaseBuilder();
            return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:sql/create.sql")
                    .addScript("classpath:sql/insert.sql")
                    .build();
        }catch (Exception e){
            LOGGER.error("create the databaseSource happend error,error:{}",e.getMessage());
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan("org.tony.springframework.study.entity");
        localContainerEntityManagerFactoryBean.setJpaProperties(hinernateProperties());
        localContainerEntityManagerFactoryBean.afterPropertiesSet();
        return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
    }

    private Properties hinernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        //Properties for Hibernate Envers
        //org.hibernate.envers.audit_table_suffix：版本化实体的表名后缀
        properties.put("org.hibernate.envers.audit_table_suffix", "_H");
        //历史表列，用于存储每个历史记录的修订号
        properties.put("org.hibernate.envers.revision_field_name",
                "AUDIT_REVISION");
        //历史表列，用于存储更新操作类型
        properties.put("org.hibernate.envers.revision_type_field_name",
                "ACTION_TYPE");
        //用于实体版本控制的审计策略。
        properties.put("org.hibernate.envers.audit_strategy",
                "org.hibernate.envers.strategy.ValidityAuditStrategy");
        //历史表列，用于存储每个历史记录的最终修订号。只有在使用有效性审核策略时才需要。
        properties.put(
                "org.hibernate.envers.audit_strategy_validity_end_rev_field_name",
                "AUDIT_REVISION_END");
        //是否在更新每个历史记录的最终修订号时存储时间戳。只有在使用有效性审核策略时才需要。
        properties.put(
                "org.hibernate.envers.audit_strategy_validity_store_revend_timestamp",
                "True");
        //历史表列，用于存储每个历史记录的最终修订号更新时的时间戳。仅当使用有效性审计策略且将以前的属性设置为true时才需要
        properties.put(
                "org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name",
                "AUDIT_REVISION_END_TS");
        return properties;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

}
