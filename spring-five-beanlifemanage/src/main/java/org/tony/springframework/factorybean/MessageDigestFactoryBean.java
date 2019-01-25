package org.tony.springframework.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

import java.security.MessageDigest;

/**
 * @Description factoryBean的使用
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybean
 */
public class MessageDigestFactoryBean implements
        FactoryBean<MessageDigest> , InitializingBean{

    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    /**
     * 检索FactoryBean创建的对象
     * 这是传递给使用FactoryBean作为合作者的其他bean的实际对象
     * @return
     * @throws Exception
     */
    @Nullable
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    /***
     * 允许您告诉Spring您的FactoryBean将返回什么类型的对象
     * @return
     */
    @Nullable
    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    /***
     * 允许您通知Spring FactoryBean是否正在管理单个实例。
     * 记住，通过设置FactoryBean s <bean>标记的单例属性，
     * 可以告诉Spring FactoryBean本身的单例状态，而不是它返回的对象。
     * @return
     */
    public boolean isSingleton(){
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
