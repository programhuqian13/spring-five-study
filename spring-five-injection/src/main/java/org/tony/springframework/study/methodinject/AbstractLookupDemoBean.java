package org.tony.springframework.study.methodinject;

/**
 * Created by tony on 2019/1/20.
 */
public abstract class AbstractLookupDemoBean  implements DemoBean{

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
