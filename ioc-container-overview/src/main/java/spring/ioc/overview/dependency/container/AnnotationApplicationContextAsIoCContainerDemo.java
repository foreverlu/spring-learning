package spring.ioc.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ioc.overview.dependency.dimain.User;

import java.util.Map;

/**
 * ioc容器
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);

        //启动应用上下文
        applicationContext.refresh();

        findCollectionByType(applicationContext);

    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge(10);
        user.setName("acc");
        return user;
    }

    //根据类型查找集合对象
    private static void findCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("类型查找集合对象："+map);
        }
    }

}
