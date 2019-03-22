package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
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
 * @Date 2019/3/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.tony.springframework.study")
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder embeddedDatabaseBuilder
                    = new EmbeddedDatabaseBuilder();
            return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/create.sql", "classpath:sql/insert.sql")
                    .build();
        } catch (Exception e) {
            LOGGER.info("Error is happend create database,err: {}", e.getMessage());
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("org.tony.springframework.study");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperies());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public Properties hibernateProperies(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        return properties;
    }

}
