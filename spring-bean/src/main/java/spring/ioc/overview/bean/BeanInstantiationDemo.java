package spring.ioc.overview.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.dimain.User;

/**
 * Bean 实例化
 * 1。 普通的构造方法实例化
 * 2。 静态方法实例化
 * 3。 工厂类的实例方法
 * 4。FactoryBean
 */
public class BeanInstantiationDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");
        System.out.println("静态方法创建实例："+beanFactory.getBean("user-by-static"));

        System.out.println("工厂方法创建实例："+ beanFactory.getBean("user-by-factory"));

        System.out.println("userFacotryBean"+beanFactory.getBean("user-factory-bean",User.class));
    }
}
