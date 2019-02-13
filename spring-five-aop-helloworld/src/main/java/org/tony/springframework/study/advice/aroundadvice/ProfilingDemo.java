package org.tony.springframework.study.advice.aroundadvice;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.aroundadvice
 */
public class ProfilingDemo {

    public static void main(String... args) {
        WorkerBean workerBean = getWorkBean();
        workerBean.doSomeWork(10000000);
    }

    private static WorkerBean getWorkBean() {
        WorkerBean target = new WorkerBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());

        return (WorkerBean) factory.getProxy();
    }

}
