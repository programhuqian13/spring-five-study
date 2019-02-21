package org.tony.springframework.study.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.tony.springframework.study.dao.mapping.SelectAllSinger;
import org.tony.springframework.study.dao.mapping.SelectSingerByFirstName;
import org.tony.springframework.study.dao.update.SingerUpdate;

import javax.sql.DataSource;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@Configurable
@PropertySource({"classpath:db/jdbc.properties"})
@ComponentScan("org.tony.springframework.study")
public class ModelJdbcOperationsConfig {

    private static Logger logger = LoggerFactory.getLogger(ModelJdbcOperationsConfig.class);

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

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        return basicDataSource;
    }

    @Bean
    public SelectAllSinger selectAllSinger() {
        return new SelectAllSinger(dataSource());
    }

    @Bean
    public SelectSingerByFirstName selectSingerByFirstName() {
        return new SelectSingerByFirstName(dataSource());
    }

    @Bean
    public SingerUpdate singerUpdate(){
        return new SingerUpdate(dataSource());
    }

}
