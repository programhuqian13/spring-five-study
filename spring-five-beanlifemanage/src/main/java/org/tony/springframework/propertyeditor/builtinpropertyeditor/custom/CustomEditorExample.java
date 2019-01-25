package org.tony.springframework.propertyeditor.builtinpropertyeditor.custom;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.propertyeditor.builtinpropertyeditor.custom
 */
public class CustomEditorExample {

    private FullName name;

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-custompropertyeditor-context.xml");
        genericXmlApplicationContext.refresh();

        CustomEditorExample customEditorExample
                = (CustomEditorExample) genericXmlApplicationContext.getBean("exampleBean");

        System.out.println(customEditorExample.getName());

        genericXmlApplicationContext.close();
    }


}
