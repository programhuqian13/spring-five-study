package org.tony.springframework.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.tony.springframework.study.services.AsyncService;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class AsyncTaskDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTaskDemo.class);

    public static void main(String[] args) throws InterruptedException, IOException {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(AysnchronousTaskConfig.class);
        AsyncService service = genericApplicationContext
                .getBean("asyncService", AsyncService.class);
        for(int i = 0;i < 5;i++){
            service.asyncTask();
        }

        Future<String> result1 = service.asyncWithReturn("TOny");
        Future<String> result2 = service.asyncWithReturn("AIAI");
        Future<String> result3 = service.asyncWithReturn("TTTT");
        Thread.sleep(6000);
        LOGGER.info("result1:{}",result1);
        LOGGER.info("result2:{}",result2);
        LOGGER.info("result3:{}",result3);
        System.in.read();
        genericApplicationContext.close();
    }

}
