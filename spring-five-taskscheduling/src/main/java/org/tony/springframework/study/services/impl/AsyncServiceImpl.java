package org.tony.springframework.study.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.tony.springframework.study.services.AsyncService;

import java.util.concurrent.Future;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services.impl
 */
@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {

    final static Logger LOGGER = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Async
    @Override
    public void asyncTask() {
        LOGGER.info("Start execution of async,task");
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            LOGGER.error("Start fail!");
        }

        LOGGER.info("complate execution of async ,task");
    }

    @Async
    @Override
    public Future<String> asyncWithReturn(String name) {
        LOGGER.info("Start execution of async. task with return for "+ name);
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            LOGGER.error("Task Interruption", ex);
        }
        LOGGER.info("Complete execution of async. task with return for " + name);
        return new AsyncResult<>("Hello: " + name);
    }
}
