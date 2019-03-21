package org.tony.springframework.study.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.entity.AnotherSinger;
import org.tony.springframework.study.entity.Singer;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
public class SingerToAnotherSingerConverter implements Converter<Singer,AnotherSinger>{

    @Nullable
    @Override
    public AnotherSinger convert(Singer singer) {
        AnotherSinger anotherSinger = new AnotherSinger();
        anotherSinger.setBrithDate(singer.getBirthDate());
        anotherSinger.setFirstName(singer.getFirstName());
        anotherSinger.setLastName(singer.getLastName());
        anotherSinger.setPersonalSite(singer.getPersonalSite());
        return anotherSinger;
    }
}
