package org.tony.springframework.study.methodinject.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by tony on 2019/1/20.
 */
@Component("standardLookupDemoBean")
public class StandardLookupDemoBean implements DemoBean {

    private Singer mySinger;

    @Autowired
    @Qualifier("singer")
    public void setMySinger(Singer mySinger){
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
