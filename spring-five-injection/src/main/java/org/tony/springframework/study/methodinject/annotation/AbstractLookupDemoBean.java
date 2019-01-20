package org.tony.springframework.study.methodinject.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Created by tony on 2019/1/20.
 */
@Component("abstractLookupDemoBean")
public class AbstractLookupDemoBean implements DemoBean{

    @Lookup("singer")
    @Override
    public Singer getMySinger() {
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
