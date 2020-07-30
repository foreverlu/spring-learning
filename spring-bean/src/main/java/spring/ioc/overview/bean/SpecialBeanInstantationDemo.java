package spring.ioc.overview.bean;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * serviceLoader 实例化
 */
public class SpecialBeanInstantationDemo {

    public static void main(String[] args) {

//        demoServiceLoader();

        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/bean-special-instantiation-context.xml");
        ServiceLoader<UserFactory> serviceLoader = ac.getBean("serviceLoaderFactoryBean",ServiceLoader.class);
        doServiceLoader(serviceLoader);


        AutowireCapableBeanFactory factory = ac.getAutowireCapableBeanFactory();
        //创建UserFactory对象，通过AutowireCapableBeanFactory
        UserFactory bean = factory.createBean(DefaultUserFactory.class);
        System.out.println(bean.createUser());

    }

    //传统的serviceloader的方式
    private static void demoServiceLoader(){
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class);
        doServiceLoader(serviceLoader);
    }



    private static void doServiceLoader(ServiceLoader serviceLoader){
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }


}
