package org.tony.springframework.beanlifemanage.destructionbeanbybeanannotation;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/24
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.beanlifemanage.destructionbeanbyannotation
 */
public class DestructiveBeanAnnotation {

    public File file;
    public String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public void init() throws IOException {
        System.out.println("Initinal bean");
        if(StringUtils.isEmpty(filePath)){
            throw new IllegalArgumentException(
                    "缺少必要的参数filepath" + DestructiveBeanAnnotation.class
            );
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exits:" + file.exists());

    }

    public void destory(){
        System.out.println("destory method calling");
        if(!file.delete()){
            System.out.println("Error:删除文件失败！");
        }
        System.out.println("File exits:" + file.exists());
    }

}
