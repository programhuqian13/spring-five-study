package org.tony.springframework.study.beforeadvicesecure;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beforeadvicesecure
 */
public class SecurityManager {

    public static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String username, String password) {
        threadLocal.set(new UserInfo(username, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser() {
        return threadLocal.get();
    }

}
