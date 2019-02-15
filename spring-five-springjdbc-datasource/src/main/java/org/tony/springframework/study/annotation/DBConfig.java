package org.tony.springframework.study.annotation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * @Description 已java配置的方式配置DataSource
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.annotation
 */
@Configurable
@PropertySource("classpath:db/jdbc.properties")
public class DBConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {

        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
            dataSource.setDriverClass(driver);
            dataSource.setPassword(password);
            dataSource.setUsername(username);
            dataSource.setUrl(url);
            return dataSource;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
