package spring.ioc.overview.dependency.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.ioc.overview.dependency.dimain.User;

import java.util.Map;

/**
 * ioc容器
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String location = "META-INF/dependency-injection.xml";
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int count = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("bean definations count: "+count);
        findCollectionByType(beanFactory);


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
