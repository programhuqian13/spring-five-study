package org.tony.springframework.study.frameworkservice.usingaopnamespace;


/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.usingaopnamespace
 */
public class NewDocumentarist extends Documentarist {

    @Override
    public void execute() {
        grammyGuitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Tony");
        grammyGuitarist.sing(guitar);
        grammyGuitarist.talk();
    }
}
