package org.tony.springframework.study.beforeadvice;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.beforeadvice
 */
public class Guitarist implements Singer {

    private String lyric = "你是我的眼......";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
