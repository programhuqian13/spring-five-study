package org.tony.springframework.study;

/**
 * @Description aspectj对象 定义相关切面及方法
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public aspect MessageWrapper {

//    private String prefix;
//
//    private String suffix;
//
//    public String getPrefix() {
//        return prefix;
//    }
//
//    public void setPrefix(String prefix) {
//        this.prefix = prefix;
//    }
//
//    public String getSuffix() {
//        return suffix;
//    }

//    public void setSuffix(String suffix) {
//        this.suffix = suffix;
//    }

    //定义一个切面
    pointcut doWriting():
            execution(* org.tony.springframework.study.MessageWriter.writeMessage());
    //进行相关的前置操作
    before(): doWriting(){
        System.out.println("The Prefix");
    }

    ////进行相关的后置操作
    after(): doWriting(){
        System.out.println("The Suffix");
    }
}
