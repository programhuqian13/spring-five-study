package org.tony.springframework.study.advice.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.aroundadvice
 * @see org.aopalliance.intercept.MethodInterceptor
 */
public class ProfilingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start(methodInvocation.getMethod().getName());

        Object returnValue = methodInvocation.proceed();

        watch.stop();
        dumpInfo(methodInvocation, watch.getTotalTimeMillis());
        return returnValue;
    }

    /***
     *
     * @param invocation
     * @param ms
     * @see org.aopalliance.intercept.MethodInvocation
     */
    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("执行方法：" + m.getName());
        System.out.println("On object of type: " + target.getClass().getName());

        System.out.println("With arguments:");
        for (int x = 0; x < args.length; x++) {
            System.out.println("     > " + args[x]);
        }
        System.out.println("\n");
        System.out.println("Took: " + ms + " ms");
    }
}
