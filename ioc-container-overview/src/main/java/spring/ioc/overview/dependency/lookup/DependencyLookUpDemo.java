package spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.annotation.Super;
import spring.ioc.overview.dependency.dimain.User;

import java.util.Map;

/**
 * 依赖查找
 * 1。根据名称查找
 * 1） 实时查找
 * 2）延迟查找   ObjectFactory
 *
 * 2。 按照类型查找
 * 单一对象
 * 集合对象
 *
 * 3。根据Bean名称  + 类型查找
 *
 * 4。 根据java注解查找
 * 单个对象
 * 集合对象
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup.xml");

        findInRealTime(beanFactory);
        findInDelay(beanFactory);

        findSingleByType(beanFactory);
        findCollectionByType(beanFactory);

        findByAnnotation(beanFactory);
    }

    //实时查找
    private static void findInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找："+user);
    }

    //延迟查找  ObjectFactory
    private static void findInDelay(BeanFactory beanFactory){
            ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
            User user = objectFactory.getObject();
            System.out.println("延迟查找："+user);
    }

    //根据类型查找单一对象
    private static void findSingleByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println("类型查找单一对象："+user);  //结合primary使用
    }

    //根据类型查找集合对象
    private static void findCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("类型查找集合对象："+map);
        }
    }

    //根据注解查找
    private static void findByAnnotation(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, Object> map = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("注解查找对象："+map);
        }
    }
}
