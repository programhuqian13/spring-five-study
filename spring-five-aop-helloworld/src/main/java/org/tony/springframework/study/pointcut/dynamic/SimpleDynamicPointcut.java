package org.tony.springframework.study.pointcut.dynamic;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Description 定义一个动态的切入点
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.dynamicpointcut
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = ((Integer) args[0]).intValue();
        return (x != 100);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> (aClass == SampleBean.class);
    }
}
