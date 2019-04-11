package org.tony.springframework.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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
public class TaskExecutorConfig {

    @Bean
    public TaskExecutor taskExecutor(){
//        return new SimpleAsyncTaskExecutor();  //在每次调用时创建新线程;不重用现有线程
        //return new SyncTaskExecutor(); //不异步执行;调用发生在调用线程中
        //return new SimpleThreadPoolTaskExecutor();  //Quartz的SimpleThreadPool子类;当需要由Quartz和非Quartz组件共享线程池时使用
        ////TaskExecutor实现提供了通过bean属性配置ThreadPoolExecutor并将其公开为Spring TaskExecutor的功能
        return new ThreadPoolTaskExecutor();
    }

}
