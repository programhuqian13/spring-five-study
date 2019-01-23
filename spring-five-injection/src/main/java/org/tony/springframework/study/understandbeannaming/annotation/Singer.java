package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.stereotype.Component;

/**
 * @Description @Component声明一个bean，不带参数的情况下，和类名是同名，首字母变为小写
 * 如果想不一样的话，可以添加一个参数，这个参数为bean的id和name
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
@Component
public class Singer {

    private String lyric="这就是爱";

    public void sing(){
        System.out.println(lyric);
    }

}
