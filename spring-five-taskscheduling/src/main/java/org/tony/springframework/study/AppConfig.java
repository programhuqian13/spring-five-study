package org.tony.springframework.study;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.tony.springframework.study.DataSourceConfig;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
@Configuration
@Import({DataSourceConfig.class})
@ImportResource("classpath:task-namespace-app-context.xml")
public class AppConfig {

}
