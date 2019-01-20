package org.tony.springframework.study.methodinject.methodreplace;

/**
 * Created by tony on 2019/1/20.
 */
public class ReplacementTarget {

    public String formatMessage(String message){
        return "<h1>" + message + "</h1>";
    }

    public String formatMessage(Object message){
        return "<h1>" + message + "</h1>";
    }

}
