package org.tony.springframework.study.injectcollect;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Description 集合注入
 * 1.map
 * 2.list
 * 3.porps
 * 4.set
 * @Version 1.0
 * @Date 2019/1/18
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.injectcollect
 */
@Service("collectInjectAnnotation")
public class CollectInjectAnnotation {

    @Resource(name="map")
    private Map<String,Object> map;

    @Resource(name="list")
    private List<String> list;

    @Resource(name="set")
    private Set<String> set;

    @Resource(name="props")
    private Properties props;

    public void displayInfo(){
        System.out.println("Map contents:");
        map.entrySet().stream().forEach(e ->
                System.out.println("key:" + e.getKey() + " - value: " + e.getValue()));

        System.out.println("Props contents:");
        props.entrySet().stream().forEach(e ->
                System.out.println("key:" + e.getKey() + " - value: " + e.getValue()));

        System.out.println("Set contents:");
        set.stream().forEach(obj -> System.out.println("Value: " + obj));

        System.out.println("List contents:");
        list.stream().forEach(obj -> System.out.println("Value " + obj));

    }
}