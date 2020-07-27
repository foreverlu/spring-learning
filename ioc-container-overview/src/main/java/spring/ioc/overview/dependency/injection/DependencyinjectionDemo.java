package spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.dependency.annotation.Super;
import spring.ioc.overview.dependency.dimain.User;
import spring.ioc.overview.dependency.repository.UserRepository;

import java.util.Map;

/**
 * 依赖注入
 * 1。根据bean的名称注入
 *
 * 2。根据bean的类型注入
 * 1）单个bean对象
 * 2）集合bean对象
 *
 * 3。注入容器内建对象
 *
 * 4。注入非bean对象
 *
 * 5。注入类型
 * 1）实时注入
 * 2）延迟注入
 */
public class DependencyinjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection.xml");
        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository"); //自定义bean
        System.out.println(userRepository);

        //内建非bean对象，
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(beanFactory.getBean(BeanFactory.class));  //依赖查找，非bean对象 所以找不到

        //内建bean对象
        System.out.println(userRepository.getObjectFactory().getObject());

        System.out.println(userRepository.getObjectFactorya().getObject());

    }

}
