package org.tony.springframework.study.introductions.objectmodificationdetection;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/14
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.introductions.objectmodificationdetection
 * @see org.springframework.aop.support.DefaultIntroductionAdvisor
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor{

    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
