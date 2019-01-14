package com.tony.springframework.study.helloworld;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/10
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.helloworld
 */
public class HelloWorld {

    public static void main(String ... args){
        if(args.length > 0){
            System.out.println(args[0]);
        }
        System.out.println("Hello World!");
    }

}
