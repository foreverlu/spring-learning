package spring.ioc.overview.bean;

import javax.annotation.PostConstruct;

public class DefaultUserFactory implements UserFactory{

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct 初始化");
    }
}
