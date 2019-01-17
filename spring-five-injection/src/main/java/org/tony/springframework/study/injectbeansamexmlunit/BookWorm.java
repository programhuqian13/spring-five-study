package org.tony.springframework.study.injectbeansamexmlunit;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/17
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectbeansamexmlunit
 */
public class BookWorm implements Oracle{

    @Override
    public String defineMeaningOfLife() {
        return "this is a inject bean same xml unit";
    }
}
