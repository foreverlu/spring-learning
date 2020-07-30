package spring.ioc.overview.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import spring.ioc.overview.dependency.dimain.User;

public class UserFactoryBean implements FactoryBean<User> {
    public User getObject() throws Exception {
        return User.createUser();
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
