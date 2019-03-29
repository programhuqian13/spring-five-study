package org.tony.springframework.study;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;
import java.util.Properties;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/29
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.tony.springframework.study")
public class ServiceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceConfig.class);

    @Bean(initMethod = "init", destroyMethod = "shutdownForce")
    public UserTransactionService userTransactionService() {
        Properties properties = new Properties();
        properties.put("com.atomikos.icatch.service", "com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        return new UserTransactionServiceImp(properties);
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    @DependsOn("userTransactionService")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setStartupTransactionService(false);
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Bean
    @DependsOn("userTransactionService")
    public UserTransaction userTransaction() {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        try {
            userTransactionImp.setTransactionTimeout(300);
        } catch (Exception e) {
            LOGGER.error("Configuration happend error,error:{}", e.getMessage());
            return null;
        }
        return userTransactionImp;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
        jtaTransactionManager.setUserTransaction(userTransaction());
        return jtaTransactionManager;
    }
}
