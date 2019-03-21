package org.tony.springframework.study.formatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @Description 自定义转换的convertionService
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.converter
 */
@Service("conversionService")
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConversionServiceFactoryBean.class);

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    private DateTimeFormatter dateTimeFormatter;

    private String pattern = DEFAULT_DATE_PATTERN;

    public Set<Formatter> getFormatterSet() {
        return formatterSet;
    }

    public void setFormatterSet(Set<Formatter> formatterSet) {
        this.formatterSet = formatterSet;
    }

    private Set<Formatter> formatterSet = new HashSet<>();

    public String getPattern() {
        return pattern;
    }

    //这个属性是否是必须的
    @Autowired(required = false)
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @PostConstruct
    public void init() {
        dateTimeFormatter = DateTimeFormat.forPattern(pattern);
        //添加相关的formatter
        formatterSet.add(getDateTimeFormatter());
        setFormatterSet(formatterSet);
    }

    public Formatter<DateTime> getDateTimeFormatter() {
        //进行字段的格式化
        return new Formatter<DateTime>() {
            //转换string对象为Datetime对象
            @Override
            public DateTime parse(String s, Locale locale) throws ParseException {
                LOGGER.info("Parasing date String:{}", s);
                return dateTimeFormatter.parseDateTime(s);
            }

            //转换DateTime对象为string对象
            @Override
            public String print(DateTime dateTime, Locale locale) {
                LOGGER.info("Formatting datetime:{}", dateTime);
                return dateTimeFormatter.print(dateTime);
            }
        };
    }


}
