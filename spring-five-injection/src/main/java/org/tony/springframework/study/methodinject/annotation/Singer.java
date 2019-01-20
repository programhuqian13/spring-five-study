package org.tony.springframework.study.methodinject.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by tony on 2019/1/20.
 */
@Component("singer")
@Scope("prototype")
public class Singer {

    public String lyric = "i played a quick game of chess with the salt and pepper shaker";

    public void sing(){

    }

}
