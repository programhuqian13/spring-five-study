package org.tony.springframework.study.beforeadvicesecure;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beforeadvicesecure
 */
public class SecurityDemo {

    public static void main(String... args) {
        SecurityManager securityManager = new SecurityManager();
        SecureBean secureBean = getSecureBean();
        securityManager.login("tony","123456");
        secureBean.writeSecureMessage();
        securityManager.logout();

        try{
            securityManager.login("error","2qsadf");
            secureBean.writeSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception Caught: " + ex.getMessage());
        }finally {
            securityManager.logout();
        }

    }

    private static SecureBean getSecureBean() {

        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(advice);
        factory.setTarget(target);

        SecureBean secureBean = (SecureBean) factory.getProxy();

        return secureBean;
    }

}
