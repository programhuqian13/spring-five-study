package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Properties;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/28
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@EnableJpaRepositories(basePackages = {"org.tony.springframework.study"})
public class DataJpaConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(DataJpaConfig.class);

    @Value("${jdbc.driverName}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        try{
            SimpleDriverDataSource simpleDriverDataSource
                   = new SimpleDriverDataSource();
            simpleDriverDataSource.setUsername(username);
            simpleDriverDataSource.setUrl(url);
            simpleDriverDataSource.setPassword(password);
            simpleDriverDataSource.setDriverClass((Class<? extends Driver>) Class.forName(driver));
            return simpleDriverDataSource;
        }catch (Exception e){
            LOGGER.error("create databaseSource happend error,error:{}",e.getMessage());
            return null;
        }
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties properties(){
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
//hibernateProp.put("hibernate.format_sql", true);Chapter 9 ■ transaCtion ManageMent
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setJpaProperties(properties());
        managerFactoryBean.setPackagesToScan("org.tony.springframework.study.entity");
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        managerFactoryBean.afterPropertiesSet();
        return managerFactoryBean.getNativeEntityManagerFactory();
    }

}
