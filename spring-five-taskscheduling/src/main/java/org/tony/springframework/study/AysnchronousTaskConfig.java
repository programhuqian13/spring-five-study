package org.tony.springframework.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@ComponentScan("org.tony.springframework.study")
@EnableAsync
public class AysnchronousTaskConfig {
}
