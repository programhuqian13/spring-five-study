package org.tony.springframework.study.methodinject.methodreplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * spring提供的方法替换需要相关的类实现MethodReplacer接口
 * Created by tony on 2019/1/20.
 */
public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object args0, Method method, Object... args) throws Throwable {
        if(isFormatMessageMethod(method)){
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        }else{
            throw new IllegalArgumentException("unable to reimplement method" + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method){
        if(method.getParameterTypes().length != 1){
            return false;
        }

        if(!("formatMessage".equals(method.getName()))){
            return false;
        }

        if(method.getReturnType() != String.class){
            return false;
        }

        if(method.getParameterTypes()[0] != String.class){
            return false;
        }
        return true;
    }
}
