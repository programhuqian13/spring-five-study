package org.tony.springframework.study.frameworkservice.usingproxyfactorybean;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingproxyfactorybean
 */
public class Documentarist {

    protected GrammyGuitarist grammyGuitarist;

    public void execute() {
        grammyGuitarist.sing();
        grammyGuitarist.talk();
    }

    public void setGrammyGuitarist(GrammyGuitarist grammyGuitarist){
        this.grammyGuitarist = grammyGuitarist;
    }

}
