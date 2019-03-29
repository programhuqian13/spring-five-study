package org.tony.springframework.study;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@EnableJpaRepositories
public class XAJpaConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(XAJpaConfig.class);

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceA() {
        try {
            AtomikosDataSourceBean atomikosDataSourceBean
                    = new AtomikosDataSourceBean();
            atomikosDataSourceBean.setUniqueResourceName("XADBMSA");
            atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
            atomikosDataSourceBean.setXaProperties(xaAProperties());
            atomikosDataSourceBean.setPoolSize(1);
            return atomikosDataSourceBean;
        } catch (Exception e) {
            LOGGER.error("create datasourceA happend error,error:{}", e.getMessage());
            return null;
        }
    }

    @Bean
    public Properties xaAProperties(){
        Properties properties = new Properties();
        properties.put("databaseName","musicdb_a");
        properties.put("user","root");
        properties.put("password","huqian");
        properties.put("url","jdbc:mysql://localhost:3306/musicdb_a?serverTimezone=UTC");
        return properties;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceB() {
        try {
            AtomikosDataSourceBean atomikosDataSourceBean
                    = new AtomikosDataSourceBean();
            atomikosDataSourceBean.setUniqueResourceName("XADBMSB");
            atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
            atomikosDataSourceBean.setXaProperties(xaBProperties());
            atomikosDataSourceBean.setPoolSize(1);
            return atomikosDataSourceBean;
        } catch (Exception e) {
            LOGGER.error("create datasourceB happend error,error:{}", e.getMessage());
            return null;
        }
    }

    @Bean
    public Properties xaBProperties() {
        Properties xaProp = new Properties();
        xaProp.put("databaseName", "musicdb_b");
        xaProp.put("user", "root");
        xaProp.put("password", "huqian");
        xaProp.put("url","jdbc:mysql://localhost:3306/musicdb_b?serverTimezone=UTC");
        return xaProp;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.transaction.factory_class",
                "org.hibernate.transaction.JTATransactionFactory");
        hibernateProp.put("hibernate.transaction.jta.platform",
                "com.atomikos.icatch.jta.hibernate4.AtomikosPlatform");
// required by Hibernate 5
        hibernateProp.put("hibernate.transaction.coordinator_class", "jta");
        hibernateProp.put("hibernate.dialect",
                "org.hibernate.dialect.MySQL5Dialect");
// this will work only if users/schemas are created first,
// use ddl.sql script for this
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }

    @Bean
    public EntityManagerFactory emfA() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("org.tony.springframework.study.entity");
        factoryBean.setDataSource(dataSourceA());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfA");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public EntityManagerFactory emfB() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("org.tony.springframework.study.entity");
        factoryBean.setDataSource(dataSourceB());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setPersistenceUnitName("emfB");
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

}
