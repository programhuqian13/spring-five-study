package org.tony.springframework.beanlifemanage.destructionbeanbyinterface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.destructionbeanbyinterface
 */
public class DestructiveBeanInterface implements InitializingBean,DisposableBean{

    private File file;

    private String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destorying bean");
        if(!file.delete()) {
            System.out.println("Error:删除文件失败");
        }
        System.out.println("file exits:" + file.exists());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initinal bean");

        if(filePath == null){
            throw new IllegalArgumentException(
                    "缺少必要的参数filepath" + DestructiveBeanInterface.class
            );
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("file exits:" + file.exists());
    }

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-destorybean-callinterface.xml");
        genericXmlApplicationContext.refresh();

        DestructiveBeanInterface destructiveBeanInterface = (DestructiveBeanInterface) genericXmlApplicationContext.getBean("destructiveBeanInterface");

        System.out.println("Destorying is calling");
        genericXmlApplicationContext.close();
        System.out.println("Destorying is called");
    }
}
