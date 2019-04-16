package org.tony.springframework.study;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DataServiceConfig.class
        };
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                HttpInvokerConfig.class,WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/invoker/*"};
    }
}
