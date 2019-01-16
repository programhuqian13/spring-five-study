package org.tony.springframework.study.fieldinject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 字段注入
 * Spring中支持第三种类型的依赖注入，称为字段注入。
 * 顾名思义，依赖项直接注入字段，不需要构造函数或setter。
 * 这是通过使用Autowired注释对类成员进行注释来完成的
 * 虽然以这种方式添加依赖关系很容易，但是我们必须小心，不要违反单一责任原则。
 * 有更多的依赖意味着类有更多的责任，这可能导致在重构时难以分离关注点。
 * 当类变得臃肿时，使用构造函数或setter设置依赖项更容易看到这种情况，
 * 但在使用字段注入时，这种情况很容易隐藏。注入依赖项的责任在Spring中传递给容器，
 * 但是类应该使用p清楚地传递所需依赖项的类型
 * @Version 1.0
 * @Date 2019/1/16
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.fieldinject
 */
@Service("singer")
public class Singer {

    @Autowired
    private Inspiration inspiration;

    public void sing(){
        System.out.println(".........." + inspiration.getLyric());
    }

}
