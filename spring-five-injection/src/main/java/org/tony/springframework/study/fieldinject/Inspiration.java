package org.tony.springframework.study.fieldinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.fieldinject
 */
@Component
public class Inspiration {

    private String lyric =
            "this is a field inject";
    public Inspiration(
            @Value("this is a field inject value") String lyric){
        this.lyric = lyric;
    }

    public String getLyric(){
        return lyric;
    }

    public void setLyric(String lyric){
        this.lyric = lyric;
    }

}
