package org.tony.springframework.propertyeditor.builtinpropertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.propertyeditor.builtinpropertyeditor
 */
public class PropertyEditorBean {

    private byte [] bytes; //ByteArrayPropertyEditor

    private Character character; //CharacterEditor

    private Class cls; //ClassEditor

    private Boolean trueOrFalse;  //CustomBooleanEditor

    private List<String> stringList;  //CustomCollectionEditor

    private Date date;  //CustomDateEditor

    private Float floatValue;  //CustomNumberEditor

    private File file; //FileEditor

    private InputStream stream;  //InputStreamEditor

    private Locale locale; //LocaleEditor

    private Pattern pattern;  //PatternEditor

    private Properties properties;  //PropertiesEditor

    private String trimString;  //StringTrimmerEditor

    private URL url;  //URLEditor


    public void setCharacter(Character character){
        System.out.println("Setting character: " + character);
        this.character = character;
    }

    public void setCls(Class cls){
        System.out.println("Setting class: " + cls.getName());
        this.cls = cls;
    }

    public void setFile(File file){
        System.out.println("Setting file: " + file.getName());
        this.file = file;
    }

    public void setLocale(Locale locale){
        System.out.println("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setProperties(Properties properties){
        System.out.println("Loaded " + properties.size() + " properties");
        this.properties = properties;
    }

    public void setUrl(URL url){
        System.out.println("Setting URL: " + url.toExternalForm());
        this.url = url;
    }

    public void setBytes(byte ... bytes){
        System.out.println("Setting bytes: " + Arrays.toString(bytes));
        this.bytes = bytes;
    }

    public void setTrueOrFalse(boolean trueOrFalse){
        System.out.println("Setting Boolean: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList){
        System.out.println("Setting string list with size: "
         + stringList.size());
        this.stringList = stringList;

        for(String string : stringList){
            System.out.println("String member: " + string);
        }
    }

    public void setDate(Date date){
        System.out.println("Setting date: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue){
        System.out.println("Setting float value: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setStream(InputStream inputStream){
        System.out.println("Setting stream: " + inputStream);
        this.stream = inputStream;
    }

    public void setPattern(Pattern pattern){
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setTrimString(String trimString){
        System.out.println("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public static class CustomPropertyEditorRegister implements
            PropertyEditorRegistrar{

        @Override
        public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("yyyy/MM/dd");
            propertyEditorRegistry
                    .registerCustomEditor(Date.class,
                            new CustomDateEditor(simpleDateFormat,true));
            propertyEditorRegistry.registerCustomEditor(String.class
                    ,new StringTrimmerEditor(true));
        }
    }

    public static void main(String ... args) throws IOException {
        File file = File.createTempFile("test","txt");
        file.deleteOnExit();

        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-propertyeditor-context.xml");
        genericXmlApplicationContext.refresh();

        PropertyEditorBean bean = (PropertyEditorBean) genericXmlApplicationContext.getBean("builtInSample");

        genericXmlApplicationContext.close();
    }



}
