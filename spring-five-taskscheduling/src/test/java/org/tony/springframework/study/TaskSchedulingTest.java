package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.services.CarService;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class TaskSchedulingTest {

    final static Logger logger = LoggerFactory.getLogger(TaskSchedulingTest.class);

    public static void main(String... args) throws Exception{
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarService carService = ctx.getBean("carService", CarService.class);
        while (!carService.isDone()) {
            logger.info("Waiting for scheduled job to end ...");
            Thread.sleep(250);
        }
        ctx.close();
    }

}
