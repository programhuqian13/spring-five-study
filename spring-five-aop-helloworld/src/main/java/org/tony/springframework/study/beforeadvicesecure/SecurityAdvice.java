package org.tony.springframework.study.beforeadvicesecure;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beforeadvicesecure
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedOnUser();

        if (userInfo == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: "
                    + method.getName());
        } else if ("tony".equals(userInfo.getUsername())) {
            System.out.println("Logged in user is tony - okay!");
        } else {
            System.out.println("Logged in user is " + userInfo.getUsername()
                    + " not good :(");
            throw new SecurityException("User: " + userInfo.getUsername()
                    + " is not allowed access to method " + method.getName());
        }
    }
}
