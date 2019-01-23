package org.tony.springframework.study.understandbeannaming.annotation;

import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/22
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.understandbeannaming.annotation
 */
@Component("johnMayer")
@Award(prize = {"grammy","platinum disk"})
public class SingerAlias {

    private String lyric="这就是爱";

    public void sing(){
        System.out.println(lyric);
    }

}
