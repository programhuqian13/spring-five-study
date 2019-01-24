package org.tony.springframework.beanlifemanage.destructionbeanbymethod;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * @Description bean销毁的时候调用相应的方法
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.destructionbeanbymethod
 */
public class DestructiveBean implements InitializingBean{

    private File file;

    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("Initinalzing bean");

        if(filePath == null){
            throw new IllegalArgumentException(
                    "必须指定属性filepath" + DestructiveBean.class
            );
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exits: " + file.exists());
    }

    public void destory(){
        System.out.println("Destorying bean");
        if(!file.delete()){
            System.out.println("Error:删除文件失败");
        }

        System.out.println("File exits: " + file.exists());
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public static void main(String ... args){

        GenericXmlApplicationContext genericXmlApplicationContext
                 = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-destorybean-callmethod.xml");
        genericXmlApplicationContext.refresh();

        DestructiveBean destructiveBean = (DestructiveBean) genericXmlApplicationContext.getBean("destructiveBean");
        System.out.println("Calling destory()");
//        genericXmlApplicationContext.destroy();  //destory已经过期了 使用close方法替换
        genericXmlApplicationContext.close();
        System.out.println("Called destory()");
    }


}
