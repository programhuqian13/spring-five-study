package org.tony.springframework.study.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;

/**
 * @Description 进行string转换为DateTime使用Converter接口
 * 这意味着转换器负责将字符串(源类型S)转换为DateTime类型(目标类型T)。
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
public class StringToDateTimeConverter implements Converter<String,DateTime> {

    private static final String DEFULT_DATE_PATTERN = "yyyy-MM-dd";

    private DateTimeFormatter dateTimeFormatter;

    private String datePattern = DEFULT_DATE_PATTERN;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    //启动spring时候执行
    @PostConstruct
    public void init(){
        dateTimeFormatter = DateTimeFormat.forPattern(datePattern);
    }

    @Nullable
    @Override
    public DateTime convert(String dateString) {
        return dateTimeFormatter.parseDateTime(dateString);
    }
}
