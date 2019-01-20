package org.tony.springframework.study.methodinject;

/**
 * Created by tony on 2019/1/20.
 */
public class StandardLookupDemoBean implements DemoBean {

    private Singer mySinger;

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
