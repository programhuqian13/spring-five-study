package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

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
            embeddedDatabaseBuilder.addScripts("classpath::sql/create.sql", "classpath:sql/insert.sql");
            return embeddedDatabaseBuilder.build();
        } catch (Exception e) {
            LOGGER.info("Error is happend create database,err: {}", e.getMessage());
            return null;
        }
    }

}
