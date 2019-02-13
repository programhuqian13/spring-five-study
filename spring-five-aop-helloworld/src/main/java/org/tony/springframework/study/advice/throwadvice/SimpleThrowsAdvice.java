package org.tony.springframework.study.advice.throwadvice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.throwadvice
 * @see org.springframework.aop.ThrowsAdvice
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {

    public static void main(String... args) throws Exception {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(errorBean);
        factory.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) factory.getProxy();

        try {
            proxy.errorPtoneMethod();
        } catch (Exception ignore) {

        }

        try {
            proxy.otherErrorProneMethod();
        } catch (Exception ignore) {

        }
    }

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("发生了一个异常信息");
        System.out.println("异常： " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object args, Object target, IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgument Exception");
        System.out.println("异常：" + ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
