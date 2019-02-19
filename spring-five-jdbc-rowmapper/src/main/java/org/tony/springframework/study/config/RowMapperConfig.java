package org.tony.springframework.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.dao.impl.PlainSingerDao;

import javax.sql.DataSource;
import java.sql.Driver;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@Configurable
@PropertySource({"classpath:db/jdbc.properties"})
public class RowMapperConfig {

    public static Logger logger = LoggerFactory.getLogger(RowMapperConfig.class);

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        try {
            simpleDriverDataSource.setUrl(url);
            simpleDriverDataSource.setUsername(username);
            simpleDriverDataSource.setPassword(password);
            simpleDriverDataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName));
            return simpleDriverDataSource;
        } catch (ClassNotFoundException e) {
            logger.error("create database is happend error!",e);
            return null;
        }
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public SingerDao singerDao(){
        PlainSingerDao plainSingerDao = new PlainSingerDao();
        plainSingerDao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return plainSingerDao;
    }


}
