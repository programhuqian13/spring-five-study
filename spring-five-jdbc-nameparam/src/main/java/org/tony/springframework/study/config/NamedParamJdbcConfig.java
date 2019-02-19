package org.tony.springframework.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class NamedParamJdbcConfig {

    private static Logger logger = LoggerFactory.getLogger(NamedParamJdbcConfig.class);

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {
            dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName));
            dataSource.setPassword(password);
            dataSource.setUsername(username);
            dataSource.setUrl(url);
            return dataSource;
        } catch (ClassNotFoundException e) {
            logger.error("Problem create datasource error!", e);
            return null;
        }
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public SingerDao singerDao(){
        PlainSingerDao singerDao = new PlainSingerDao();
        singerDao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return singerDao;
    }

}
