package org.tony.springframework.factorybeanwithfactorymethod;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybeanwithfactorymethod
 */
public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }



}
