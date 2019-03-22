package com.tony.springframework.study.hibernate;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/14
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate
 */
@Configuration
@ComponentScan(basePackages = "com.tony.springframework.study.hibernate")
@PropertySource(value = "classpath:spring-db.properties")
@EnableTransactionManagement  //等价xml配置中的<tx:annotation-driven>
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    /***
     * 创建一个嵌入式数据源
     * @return
     */
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder embeddedDatabaseBuilder =
                    new EmbeddedDatabaseBuilder();
            return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/create.sql", "classpath:sql/insert.sql")
                    .build();
        } catch (Exception e) {
            LOGGER.error("Embedded database bean cannot be created ", e);
            return null;
        }
    }

    //提供给sessionFactory相关的使用属性
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        //指定数据库的方言
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //开启sql语句格式化
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        //开启显示sql
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.max_fetch_depth", 3);
        properties.put("hibernate.jdbc.batch_size", 10);
        properties.put("hibernate.jdbc.fetch_size", 50);
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("com.tony.springframework.study.hibernate");
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }

}
