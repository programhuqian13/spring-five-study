package org.tony.springframework.beanlifemanage.destructionbeanbyannotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.destructionbeanbyannotation
 */
public class DestructiveAnnotation {

    public File file;

    public String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @PostConstruct
    public void init() throws IOException {

        System.out.println("Initinal Bean");
        if(StringUtils.isEmpty(filePath)){
            throw new IllegalArgumentException(
                    "缺少必要的参数filepath" + DestructiveAnnotation.class
            );
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exits:" + file.exists());

    }

    @PreDestroy
    public void destory(){
        System.out.println("destory calling");
        if(!file.delete()){
            System.out.println("Error:删除文件发生错误");
        }
        System.out.println("File exits:" + file.exists());
    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-destorybean-callannotation.xml");
        genericXmlApplicationContext.refresh();

        DestructiveAnnotation destructiveAnnotation =
                (DestructiveAnnotation) genericXmlApplicationContext.getBean("destructiveAnnotation");

        System.out.println("Destorying call");
        genericXmlApplicationContext.close();
        System.out.println("Destoried call");

    }

}
