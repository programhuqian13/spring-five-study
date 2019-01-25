package org.tony.springframework.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description 注解的方式
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybean
 */
public class MessageDigestConfigDemo {

    @Configuration
    static class MessageDigesterConfig{

        @Bean
        public MessageDigestFactoryBean shaDigest(){
            MessageDigestFactoryBean factoryOne
                    = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");
            return factoryOne;
        }

        @Bean
        public MessageDigestFactoryBean defaultDigest(){
            return new MessageDigestFactoryBean();
        }

        @Bean
        MessageDigester digester() throws Exception {
            MessageDigester digester = new MessageDigester();
            digester.setDigest1(shaDigest().getObject());
            digester.setDigest2(defaultDigest().getObject());
            return digester;
        }
    }

    public static void main(String ... args){
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);
        MessageDigester messageDigester = genericApplicationContext.getBean("digester",MessageDigester.class);
        messageDigester.digest("Hello world!");
        genericApplicationContext.close();
    }

}
