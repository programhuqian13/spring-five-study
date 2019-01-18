package org.tony.springframework.study.injectcollect;

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
public class CollectInject {

    private Map<String,Object> map;

    private List<String> list;

    private Set<String> set;

    private Properties props;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

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