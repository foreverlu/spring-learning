package spring.ioc.overview.dependency.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import spring.ioc.overview.dependency.dimain.User;

import java.applet.AppletContext;
import java.util.Collection;

public class UserRepository {

    private Collection<User> user;

    private BeanFactory beanFactory;

    private ObjectFactory<User> objectFactory;

    private ObjectFactory<ApplicationContext> objectFactorya;

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactorya() {
        return objectFactorya;
    }

    public void setObjectFactorya(ObjectFactory<ApplicationContext> objectFactorya) {
        this.objectFactorya = objectFactorya;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "user=" + user +
                '}';
    }
}
