package org.tony.springframework.study.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.task
 */
@Component
public class TaskToExecute {

    @Autowired
    private TaskExecutor taskExecutor;

    public void exccuteTask() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(() -> {
                System.out.println("Hello world task taskExecutor from thread:"
                + Thread.currentThread().getName());
            });
        }
        }

    }
