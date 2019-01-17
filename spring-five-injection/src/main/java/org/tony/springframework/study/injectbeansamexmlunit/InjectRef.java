package org.tony.springframework.study.injectbeansamexmlunit;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectbeansamexmlunit
 */
public class InjectRef {

    private Oracle oracle;

    public void setOracle(Oracle oracle){
        this.oracle = oracle;
    }

    public String toString(){
        return oracle.defineMeaningOfLife();
    }

}
