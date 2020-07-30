package spring.ioc.overview.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.dimain.User;

public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-alias.xml");
        User user = (User)beanFactory.getBean("user-alias");

        System.out.println(user);
    }
}
