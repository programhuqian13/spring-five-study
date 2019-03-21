package org.tony.springframework.study.support;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditorSupport;

/**
 * @Description 定义了一个自定义编辑器，
 * 用于将字符串转换为JodaTime的DateTime类型，
 * 并且还在属性文件中具体化了日期-时间格式模式
 * DateTimeEditorRegistrar实现PropertyEditorRegistrar注册自定义的PropertyEditor
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.support
 */
public class DateTimeEditorRegistrar implements PropertyEditorRegistrar {

    private DateTimeFormatter dateTimeFormatter;

    public DateTimeEditorRegistrar(String dateFormatPattern) {
        dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
    }

    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(DateTime.class, new DateTimeEditor(dateTimeFormatter));
    }

    private static class DateTimeEditor extends PropertyEditorSupport {

        private DateTimeFormatter dateTimeFormatter;

        public DateTimeEditor(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
        }

        //将字符串转换为时间对象
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(DateTime.parse(text, dateTimeFormatter));
        }
    }
}
