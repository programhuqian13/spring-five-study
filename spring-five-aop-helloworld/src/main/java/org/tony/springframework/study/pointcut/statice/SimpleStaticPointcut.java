package org.tony.springframework.study.pointcut.statice;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Description 定义一个静态的切面
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.staticpointcut.demo1
 * @see org.springframework.aop.support.StaticMethodMatcherPointcut
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("sing".equals(method.getName()));
    }

    /***
     * 等同于public ClassFilter getClassFilter() {
     *          return new ClassFilter() {
     *              public boolean matches(Class<?> cls) {
     *                  return (cls == GoodGuitarist.class);
     *              }
     *          };
     *       }
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return aClass -> (aClass == GoodGuitarist.class);
    }
}
