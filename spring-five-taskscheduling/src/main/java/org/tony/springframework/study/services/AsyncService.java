package org.tony.springframework.study.services;

import java.util.concurrent.Future;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.services
 */
public interface AsyncService {

    void asyncTask();

    Future<String> asyncWithReturn(String name);

}
