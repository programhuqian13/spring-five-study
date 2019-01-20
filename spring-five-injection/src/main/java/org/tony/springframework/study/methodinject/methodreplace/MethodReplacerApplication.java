package org.tony.springframework.study.methodinject.methodreplace;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by tony on 2019/1/20.
 */
public class MethodReplacerApplication {

    public static void main(String ... args){
        GenericXmlApplicationContext genericXmlApplicationContext =
                new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-methodinject-replacer-context.xml");
        genericXmlApplicationContext.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) genericXmlApplicationContext.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) genericXmlApplicationContext.getBean("standardTarget");

        disPlayInfo(replacementTarget);
        disPlayInfo(standardTarget);

        genericXmlApplicationContext.close();
    }

    private static void disPlayInfo(ReplacementTarget replacementTarget){
        System.out.println(replacementTarget.formatMessage("thanks for playing,try again!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for(int i = 0;i < 100000;i++){
            String out =   replacementTarget.formatMessage("no filter in my head");
            //System.out.println(out);
        }

        stopWatch.stop();

        System.out.println("100000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }

}
