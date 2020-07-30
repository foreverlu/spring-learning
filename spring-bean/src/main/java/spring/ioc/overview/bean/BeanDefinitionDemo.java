package spring.ioc.overview.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import spring.ioc.overview.dependency.dimain.User;

import java.util.Map;

/**
 * 注册 BeanDefinition 示例
 */
@Import(BeanDefinitionDemo.Config.class)
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanDefinitionDemo.class);

        regiterUserBean(applicationContext, "user1");
        regiterUserBean(applicationContext);
//启动spring 应用上下文
        applicationContext.refresh();
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println(beansOfType);
        System.out.println(applicationContext.getBeansOfType(Config.class));


        System.out.println("api 注册 beanDefinition ： " + applicationContext.getBeansOfType(User.class));


        //显示地关闭 spring 应用上下文
        applicationContext.close();
    }

    //api的方式注册bean
    public static void regiterUserBean(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "aaaa")
                .addPropertyValue("age", 65);
        if (StringUtils.hasText(beanName))
            //命名方式注册beandifinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        else
            //非命名方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
    }

    public static void regiterUserBean(BeanDefinitionRegistry registry) {
        regiterUserBean(registry, null);
    }


    //    @Component
    public static class Config {
        //        @Bean("new-user")
        public User getUser() {
            User user = new User();
            user.setName("test");
            user.setAge(23);
            return user;
        }
    }
}
