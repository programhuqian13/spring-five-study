package org.tony.springframework.study.frameworkservice.aspectjstyleannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.frameworkservice.aspectjstyleannotation
 */
@Component("documentarist")
public class NewDocumentarist {

    protected GrammyGuitarist grammyGuitarist;

    public void execute() {
        grammyGuitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Tony");
        grammyGuitarist.sing(guitar);
        grammyGuitarist.talk();
    }

    @Autowired
    @Qualifier("tony")
    public void setGrammyGuitarist(GrammyGuitarist grammyGuitarist) {
        this.grammyGuitarist = grammyGuitarist;
    }


}
