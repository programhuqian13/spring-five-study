package org.tony.springframework.study.beforeadvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beforeadvice
 * @see org.springframework.aop.MethodBeforeAdvice
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String ... args){
        Guitarist tont = new Guitarist();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(tont);
        factory.addAdvice(new SimpleBeforeAdvice());

        Guitarist proxyInstance = (Guitarist) factory.getProxy();

        //在这个方法之前会运行before方法
        proxyInstance.sing();
    }


    /***
     * 这个代理方式会在代理方法调用之前执行
     * @param method method being invoked
     * @param objects arguments to the method
     * @param o target of the method invocation May be null.
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("Before: " + method.getName() + "', tune guitar. ");
    }
}
