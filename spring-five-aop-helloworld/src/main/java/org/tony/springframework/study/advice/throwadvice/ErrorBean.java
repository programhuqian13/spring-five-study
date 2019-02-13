package org.tony.springframework.study.advice.throwadvice;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/13
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.advice.throwadvice
 */
public class ErrorBean {

    public void errorPtoneMethod() throws Exception {
        throw new Exception("发生了异常！");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("IllegalArgument Exception");
    }

}
