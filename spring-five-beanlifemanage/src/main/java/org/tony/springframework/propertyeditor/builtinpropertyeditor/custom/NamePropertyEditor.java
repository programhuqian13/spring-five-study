package org.tony.springframework.propertyeditor.builtinpropertyeditor.custom;

import java.beans.PropertyEditorSupport;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.propertyeditor.builtinpropertyeditor.custom
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String [] name = text.split("\\s");
        setValue(new FullName(name[0],name[1]));
    }
}
