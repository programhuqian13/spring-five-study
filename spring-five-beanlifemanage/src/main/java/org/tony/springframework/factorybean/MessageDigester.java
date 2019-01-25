package org.tony.springframework.factorybean;


import java.security.MessageDigest;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.factorybean
 */
public class MessageDigester {

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1){
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2){
        this.digest2 = digest2;
    }

    public void digest(String message){
        System.out.println("Using digest1");
        digest(message,digest1);

        System.out.println("Using digest2");
        digest(message,digest2);
    }

    public void digest(String message, MessageDigest messageDigest){
        System.out.println("Using alogrithm: " + messageDigest.getAlgorithm());
        messageDigest.reset();
        byte [] bytes = message.getBytes();
        byte [] out = messageDigest.digest(bytes);
        System.out.println(out);
    }

}
