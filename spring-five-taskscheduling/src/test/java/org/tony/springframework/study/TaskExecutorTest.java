package org.tony.springframework.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.tony.springframework.study.task.TaskToExecute;

import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/11
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class TaskExecutorTest {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        TaskToExecute executor = ctx.getBean(TaskToExecute.class);

        executor.exccuteTask();

        System.in.read();

        ctx.close();
    }

}
