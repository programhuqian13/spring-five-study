package org.tony.springframework.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @Description 嵌入式数据库 程序启动的时候的创建表和数据库等操作
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.config
 */
@Configurable
public class EmbeddedJdbcConfig {

    private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    @Bean
    public DataSource dataSource(){
        try{
            EmbeddedDatabaseBuilder databaseBuilder =
                    new EmbeddedDatabaseBuilder();
            return databaseBuilder.setType(EmbeddedDatabaseType.valueOf("mysql"))
                    .addScripts("classpath:db/create-database.sql",
                            "classpath:db/insert-data.sql").build();
        }catch (Exception e){
            logger.error("Embeded datasource bean can not be created!",e);
            return null;
        }
    }

}
