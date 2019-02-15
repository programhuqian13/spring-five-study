package org.tony.springframework.study.pointcut.composable;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import org.tony.springframework.study.pointcut.controlflow.SimpleBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.pointcut.composable
 * @see org.springframework.aop.support.ComposablePointcut
 */
public class ComposablePointcutDemo {

    public static void main(String... args) {
        GrammyGuitarist target = new GrammyGuitarist();

        ComposablePointcut composablePointcut =
                new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());

        System.out.println("Test 1 >> ");

        GrammyGuitarist proxy = getProxy(composablePointcut, target);
        testInvoke(proxy);
        System.out.println();

        System.out.println("Test 2 >> ");
        composablePointcut.union(new TalkMethodMatcher());
        proxy = getProxy(composablePointcut, target);
        testInvoke(proxy);
        System.out.println();

        System.out.println("Test 3 >> ");
        composablePointcut.intersection(new RestMethodMatcher());
        proxy = getProxy(composablePointcut, target);
        testInvoke(proxy);
        System.out.println();

    }

    private static void testInvoke(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }

    private static GrammyGuitarist getProxy(ComposablePointcut composablePointcut, GrammyGuitarist target) {
        Advisor advisor = new DefaultPointcutAdvisor(composablePointcut, new SimpleBeforeAdvice());
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(target);
        return (GrammyGuitarist) factory.getProxy();
    }


    private static class SingMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return (method.getName().startsWith("si"));
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return ("talk".equals(method.getName()));
        }
    }

    private static class RestMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return (method.getName().endsWith("st"));
        }
    }

}
